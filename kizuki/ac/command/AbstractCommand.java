package kizuki.ac.command;

import org.bukkit.command.*;
import org.jetbrains.annotations.*;

public abstract class AbstractCommand
{
    private final String command;
    private final String usage;
    
    public AbstractCommand(final String s, final String usage) {
        this.command = s.toLowerCase();
        this.usage = usage;
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public abstract boolean handleCommand(final CommandSender p0, @NotNull final Command p1, final String p2, final String[] p3);
}
