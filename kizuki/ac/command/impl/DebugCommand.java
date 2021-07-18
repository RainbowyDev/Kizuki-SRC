package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import kizuki.ac.event.*;
import kizuki.ac.data.*;
import kizuki.ac.check.*;

public class DebugCommand extends AbstractCommand
{
    public DebugCommand() {
        super("debug", "/kizuki debug <checkname>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        if (commandSender instanceof Player) {
            PlayerData playerData;
            if (array.length == 3) {
                final Player player = Bukkit.getPlayer(array[1]);
                if (player == null) {
                    commandSender.sendMessage(tu.II("playerNotFound").replace("%player%", array[1]).replace("%prefix%", AlertFormatter.II()));
                    return true;
                }
                playerData = BukkitEventListener2.II(player.getUniqueId());
            }
            else {
                if (array.length != 2) {
                    commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI("wrongNumberOfArguments").replace("%prefix%", AlertFormatter.II()).replace("%exp%", "2").replace("%args_length%", array.length + "")));
                    return true;
                }
                playerData = BukkitEventListener2.II(((Player)commandSender).getUniqueId());
            }
            final String lowerCase = array[1].toLowerCase();
            for (final KizukiCheck kizukiCheck : playerData.checks) {
                if (kizukiCheck.iI().equalsIgnoreCase(lowerCase)) {
                    kizukiCheck.thread = !kizukiCheck.thread;
                    commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI(kizukiCheck.thread ? "onDebugEnabled" : "onDebugDisabled").replace("%prefix%", AlertFormatter.II())));
                    return true;
                }
            }
            commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI("unknownCheck").replace("%prefix%", AlertFormatter.II()).replace("%arg%", lowerCase)));
            return true;
        }
        Checkable.logger.info(AlertFormatter.II() + "You can't execute this command in console");
        return true;
    }
}
