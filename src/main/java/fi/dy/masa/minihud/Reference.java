package fi.dy.masa.minihud;

import net.minecraft.SharedConstants;
import fi.dy.masa.malilib.util.StringUtils;

public class Reference
{
    public static final String MOD_ID = "purityhud";
    public static final String TRANSLATION_KEY_PREFIX = "minihud";
    public static final String MOD_NAME = "PurityHUD";
    public static final String MOD_VERSION = StringUtils.getModVersionString(MOD_ID);
    public static final String MC_VERSION = SharedConstants.getCurrentVersion().id();
    public static final String MOD_TYPE = "fabric";
    public static final String MOD_STRING = MOD_ID+"-"+MOD_TYPE+"-"+MC_VERSION+"-"+MOD_VERSION;
}
