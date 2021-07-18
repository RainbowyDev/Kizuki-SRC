package kizuki.ac;

import org.bukkit.*;
import kizuki.ac.check.*;

public class ik
{
    double II;
    
    public double II() {
        return Math.round(Math.min(20.0, this.II) * 100.0) / 100.0f;
    }
    
    public void II() {
        Bukkit.getServer().getScheduler().runTaskTimer(Checkable.plugin, (Runnable)new il(this), 0L, 1L);
    }
}
