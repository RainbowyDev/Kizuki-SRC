package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import kizuki.ac.alert.*;

public class InfoCommand extends AbstractCommand
{
    public InfoCommand() {
        super("info", "/kizuki info");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        try {
            commandSender.sendMessage(AlertFormatter.iI(AlertFormatter.lI("info")));
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
    }
}
