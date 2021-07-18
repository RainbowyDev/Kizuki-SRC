package kizuki.ac.api;

import kizuki.ac.check.*;
import org.bukkit.entity.*;
import kizuki.ac.event.*;
import org.bukkit.*;
import org.bukkit.event.*;
import kizuki.ac.utils.*;

public class KizukiAntiCheatAPI
{
    public static String BYPASS_PERMISSION;
    
    public static String getVersion() {
        return Checkable.plugin.getDescription().getVersion();
    }
    
    public static String getBypassPermission() {
        return KizukiAntiCheatAPI.BYPASS_PERMISSION;
    }
    
    public static LimitedDouble getVLManager(final Player player, final KizukiACCheckAPI kizukiACCheckAPI) {
        return BukkitEventListener2.II(player.getUniqueId()).iI(kizukiACCheckAPI.check.iI()).II();
    }
    
    public static void flag(final boolean b, final Player player, final KizukiACCheckAPI kizukiACCheckAPI, final float n, final String s) {
        if (b || (player.hasPermission(getBypassPermission()) && !Checkable.II().getBoolean("bypassIgnore"))) {
            return;
        }
        TaskUtils.runTask(() -> Bukkit.getServer().getPluginManager().callEvent((Event)new KizukiACFlagEvent(player, kizukiACCheckAPI, s, n)));
    }
    
    static {
        KizukiAntiCheatAPI.BYPASS_PERMISSION = "kizuki.bypass";
    }
}
