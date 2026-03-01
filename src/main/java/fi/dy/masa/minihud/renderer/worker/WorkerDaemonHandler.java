package fi.dy.masa.minihud.renderer.worker;

import java.util.concurrent.PriorityBlockingQueue;
import com.google.common.collect.Queues;

import net.minecraft.client.Minecraft;

import fi.dy.masa.malilib.interfaces.IThreadDaemonHandler;
import fi.dy.masa.malilib.util.MathUtils;
import fi.dy.masa.minihud.MiniHUD;
import fi.dy.masa.minihud.Reference;

public class WorkerDaemonHandler implements IThreadDaemonHandler<AbstractWorkerTask<?>>
{
	public static final WorkerDaemonHandler INSTANCE = new WorkerDaemonHandler();
	private static final float TASK_INTERVAL = 3.0F;
	private final String threadName = Reference.MOD_NAME + " Worker Thread";
	private final WorkerDaemonExecutor executor = new WorkerDaemonExecutor();
	private final PriorityBlockingQueue<AbstractWorkerTask<?>> queue = Queues.newPriorityBlockingQueue();
	private Thread thread;
	private long lastTick;

	private WorkerDaemonHandler()
	{
		this.lastTick = System.currentTimeMillis();
	}

	@Override
	public void start()
	{
		this.ensureThreadAlive();
	}

	@Override
	public void stop()
	{
		this.executor.stop();

		if (this.thread != null && this.thread.isAlive())
		{
			this.thread.interrupt();
		}
	}

	@Override
	public void reset()
	{
		this.queue.clear();
		this.stop();
		this.start();
	}

	@Override
	public void addTask(AbstractWorkerTask<?> task)
	{
		if (this.queue.size() < 64000)
		{
			final int lastSize = this.queue.size();
			this.queue.offer(task);

			if (lastSize == 0)
			{
				this.ensureThreadAlive();
			}
		}
	}

	@Override
	public AbstractWorkerTask<?> getNextTask()
	{
		return this.queue.poll();
	}

	@Override
	public long getTaskInterval()
	{
		return MathUtils.floor(TASK_INTERVAL * 1000L);
	}

	@Override
	public void onClientTick(Minecraft mc)
	{
		final long now = System.currentTimeMillis();

		if ((now - this.lastTick) > this.getTaskInterval())
		{
			MiniHUD.debugLog("taskCount: [{}]", this.queue.size());
			this.ensureThreadAlive();
			this.lastTick = now;
		}
	}

	public void endAll()
	{
		this.stop();
		this.queue.clear();
	}

	public boolean hasTasks()
	{
		return !this.queue.isEmpty();
	}

	private void ensureThreadAlive()
	{
		if (!this.hasTasks())
		{
			return;
		}

		if (this.thread == null || !this.thread.isAlive())
		{
			this.executor.start();
			this.thread = new Thread(this.executor, this.threadName);
			this.thread.setDaemon(true);
			this.thread.start();
		}
	}

	@Override
	public void close()
	{
		this.stop();
		this.queue.clear();
	}
}
