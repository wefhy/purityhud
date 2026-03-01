package fi.dy.masa.minihud.renderer.worker;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import fi.dy.masa.malilib.interfaces.IThreadDaemonExecutor;
import fi.dy.masa.minihud.MiniHUD;

public class WorkerDaemonExecutor implements IThreadDaemonExecutor<AbstractWorkerTask<?>>
{
	private final AtomicBoolean running = new AtomicBoolean(true);

	@Override
	public boolean isRunning()
	{
		return this.running.get();
	}

	@Override
	public void start()
	{
		this.running.set(true);
	}

	@Override
	public void stop()
	{
		this.running.set(false);
	}

	@Override
	public void run()
	{
		while (this.isRunning())
		{
			try
			{
				AbstractWorkerTask<?> task = WorkerDaemonHandler.INSTANCE.getNextTask();

				if (task != null)
				{
					this.processTask(task);
				}
				else
				{
					Thread.sleep(10L);
				}
			}
			catch (InterruptedException interrupt)
			{
				MiniHUD.debugLog("Executor interrupted: {}", Objects.toString(interrupt.getLocalizedMessage(), "no message"));
				this.stop();
				Thread.currentThread().interrupt();
				return;
			}
			catch (Exception err)
			{
				MiniHUD.LOGGER.error("WorkerDaemonExecutor: Exception: {}", err.getLocalizedMessage());
				this.stop();
				return;
			}
		}
	}

	@Override
	public void processTask(AbstractWorkerTask<?> task) throws InterruptedException
	{
		task.run();
	}
}
