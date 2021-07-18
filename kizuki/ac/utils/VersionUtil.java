package kizuki.ac.utils;

import org.bukkit.entity.*;
import us.myles.ViaVersion.api.*;
import com.comphenix.protocol.*;
import org.bukkit.*;

public class VersionUtil
{
    public static final boolean VIAVERSION_ENABLED;
    public static final boolean PROTOCOLLIB_ENABLED;
    
    public static version getClientVersion(final Player player) {
        if (player == null) {
            return version.qx;
        }
        if (VersionUtil.VIAVERSION_ENABLED) {
            return getVersion(Via.getAPI().getPlayerVersion((Object)player));
        }
        if (VersionUtil.PROTOCOLLIB_ENABLED) {
            return getVersion(ProtocolLibrary.getProtocolManager().getProtocolVersion(player));
        }
        return version.qx;
    }
    
    public static boolean isNewerThan1_8(final version version) {
        return version.II() > 47;
    }
    
    public static boolean isNewerThan1_12_2(final version version) {
        return version.II() > 340;
    }
    
    public static version getVersion(final int n) {
        for (final version version : version.values()) {
            if (version.II() == n) {
                return version;
            }
        }
        return version.qx;
    }
    
    static {
        VIAVERSION_ENABLED = Bukkit.getServer().getPluginManager().isPluginEnabled("ViaVersion");
        PROTOCOLLIB_ENABLED = Bukkit.getServer().getPluginManager().isPluginEnabled("ProtocolLib");
    }
}
