package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import kizuki.ac.alert.*;
import org.bukkit.*;

public class BroadcastCommand extends AbstractCommand
{
    public BroadcastCommand() {
        super("broadcast", "/kizuki broadcast <message>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (i != 0) {
                if (i != 1) {
                    sb.append(" ");
                }
                sb.append(array[i]);
            }
        }
        Bukkit.broadcastMessage(AlertFormatter.translateColorCodes(sb.toString()));
        return true;
    }
}
