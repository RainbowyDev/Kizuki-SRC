package kizuki.ac.utils;

import org.bukkit.scheduler.*;
import org.bukkit.*;
import kizuki.ac.check.*;

public final class TaskUtils
{
    private TaskUtils() {
    }
    
    public static BukkitTask runTaskTimer(final Runnable runnable, final long n, final long n2) {
        return Bukkit.getScheduler().runTaskTimer(Checkable.plugin, runnable, n, n2);
    }
    
    public static BukkitTask runTaskTimerAsync(final Runnable runnable, final long n, final long n2) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(Checkable.plugin, runnable, n, n2);
    }
    
    public static BukkitTask runTask(final Runnable runnable) {
        return Bukkit.getScheduler().runTask(Checkable.plugin, runnable);
    }
    
    public static BukkitTask runTaskAsync(final Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(Checkable.plugin, runnable);
    }
    
    public static BukkitTask runTaskLater(final Runnable runnable, final long n) {
        return Bukkit.getScheduler().runTaskLater(Checkable.plugin, runnable, n);
    }
    
    public static BukkitTask runTaskLaterAsync(final Runnable runnable, final long n) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(Checkable.plugin, runnable, n);
    }
}
