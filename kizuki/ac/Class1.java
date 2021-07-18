package kizuki.ac;

import org.bukkit.plugin.*;
import java.util.concurrent.*;
import kizuki.ac.bstats.*;
import org.bukkit.*;
import kizuki.ac.check.*;
import kizuki.ac.api.*;

public class Class1
{
    public Class1(final Main main) {
        final Metrics metrics = new Metrics((Plugin)main);
        metrics.II(true);
        this.II(metrics);
    }
    
    private void II(final Metrics metrics) {
        metrics.II(new is("pluginVersion", this::II));
        metrics.II(new is("serverBrand", this::iI));
    }
    
    private String iI() {
        if (!Bukkit.getServer().getName().equals("CraftBukkit")) {
            return Bukkit.getServer().getName();
        }
        return "Spigot";
    }
    
    private String Ii() {
        final String version = Checkable.plugin.getDescription().getVersion();
        if (version.contains("-b")) {
            return version.split("-b")[1];
        }
        if (!version.contains("SNAPSHOT")) {
            return "Release";
        }
        return "Unknown";
    }
    
    public String II() {
        return KizukiAntiCheatAPI.getVersion();
    }
}
