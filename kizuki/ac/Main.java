package kizuki.ac;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import kizuki.ac.packet.*;
import kizuki.ac.check.*;
import org.bukkit.event.*;
import kizuki.ac.event.*;
import kizuki.ac.command.*;
import org.bukkit.command.*;
import java.io.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public final Logger logger;
    private final String name;
    private final String mainCommand;
    public PacketManager packetEvents;
    
    public Main() {
        this.logger = this.getLogger();
        this.name = this.getDescription().getName();
        this.mainCommand = this.getDescription().getCommands().keySet().toArray()[0].toString();
    }
    
    public void onEnable() {
        this.preInit();
        Checkable.II.II();
        Checkable.II.II();
        this.logger.info("Started TPS/LAG handler!");
        Checkable.plugin.getServer().getPluginManager().registerEvents((Listener)new BukkitEventListener2(), Checkable.plugin);
        Checkable.plugin.getServer().getPluginManager().registerEvents((Listener)new BukkitEventListener(), Checkable.plugin);
        Checkable.plugin.getServer().getPluginManager().registerEvents((Listener)new BukkitEventListener3(), Checkable.plugin);
        this.logger.info("Registered basic events!");
        this.startConfig();
        this.logger.info("Loaded config!");
        try {
            this.packetEvents = new PacketManager();
        }
        catch (Exception ex2) {
            this.logger.warning("You should install ProtocolLib!");
            return;
        }
        this.logger.warning("Packet events are started!");
        this.getServer().getPluginCommand(this.mainCommand).setExecutor((CommandExecutor)new CommandManager());
        this.getCommand(this.mainCommand).setExecutor((CommandExecutor)new CommandManager());
        this.logger.warning("Command are registered!");
        new ih();
        this.logger.warning("EntityTraceBacker started!");
        try {
            Checkable.II = new Class1(this);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        ig.II();
        new Ii().II(Checkable.plugin);
        this.logger.info("Kizuki Anti-Cheat Enabled!");
    }
    
    public void onDisable() {
        this.logger.info("Kizuki Anti-Cheat Disabled!");
    }
    
    private void preInit() {
        Checkable.plugin = (Plugin)this;
        Checkable.logger = this.logger;
        Checkable.thread = Thread.currentThread();
        Checkable.II = new ik();
        Checkable.II = new ij();
        Checkable.II = this.name;
    }
    
    private void startConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        (Checkable.II = new ti("language.yml")).II();
        (Checkable.iI = new ti("config.yml")).II();
    }
}
