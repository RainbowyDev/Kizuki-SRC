package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import org.bukkit.entity.*;

public class MessageCommand extends AbstractCommand
{
    public MessageCommand() {
        super("message", "/kizuki message <player-name> <message-text>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        if (array.length >= 2) {
            try {
                final Player player = Bukkit.getPlayer(array[1]);
                if (player == null) {
                    commandSender.sendMessage(tu.II("playerNotFound").replace("%player%", array[1]).replace("%prefix%", AlertFormatter.II()));
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.length; ++i) {
                    if (i >= 2) {
                        if (i != 2) {
                            sb.append(" ");
                        }
                        sb.append(array[i]);
                    }
                }
                player.sendMessage(AlertFormatter.translateColorCodes(sb.toString()));
            }
            catch (Exception ex) {
                return false;
            }
        }
        return true;
    }
}
