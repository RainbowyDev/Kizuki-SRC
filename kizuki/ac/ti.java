package kizuki.ac;

import org.bukkit.*;
import kizuki.ac.check.*;
import org.bukkit.configuration.file.*;
import java.io.*;

public class ti
{
    private final String II;
    private File II;
    private FileConfiguration II;
    
    public ti(final String ii) {
        this.II = ii;
    }
    
    public void II() {
        this.II = new File(Bukkit.getServer().getPluginManager().getPlugin(Checkable.II).getDataFolder(), this.II);
        if (!this.II.exists()) {
            Checkable.plugin.saveResource(this.II, false);
        }
        this.II((FileConfiguration)YamlConfiguration.loadConfiguration(this.II));
    }
    
    public FileConfiguration II() {
        return this.iI();
    }
    
    public void iI() {
        try {
            this.II.save(this.II());
        }
        catch (IOException ex) {
            System.out.println("Couldn't save file");
        }
    }
    
    public void Ii() {
        this.II = (FileConfiguration)YamlConfiguration.loadConfiguration(this.II());
    }
    
    public File II() {
        return this.II;
    }
    
    public FileConfiguration iI() {
        return this.II;
    }
    
    public void II(final FileConfiguration ii) {
        this.II = ii;
    }
}
