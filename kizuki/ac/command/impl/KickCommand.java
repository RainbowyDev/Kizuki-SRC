package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import org.bukkit.entity.*;

public class KickCommand extends AbstractCommand
{
    public KickCommand() {
        super("kick", "/kizuki kick <player-name> %reason%");
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
                player.kickPlayer(AlertFormatter.translateColorCodes(sb.toString()));
                return true;
            }
            catch (Exception ex) {
                return false;
            }
        }
        commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI("wrongNumberOfArguments").replace("%prefix%", AlertFormatter.II()).replace("%exp%", "2").replace("%args_length%", array.length + "")));
        return true;
    }
}
