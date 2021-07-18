package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.entity.*;
import kizuki.ac.event.*;
import kizuki.ac.alert.*;
import kizuki.ac.check.*;
import kizuki.ac.data.*;

public class AlertsCommand extends AbstractCommand
{
    public AlertsCommand() {
        super("alerts", "/kizuki alerts");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        if (commandSender instanceof Player) {
            final PlayerData ii = BukkitEventListener2.II(((Player)commandSender).getUniqueId());
            if (array.length == 1) {
                ii.II = !ii.II;
                commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.ii(AlertFormatter.lI(ii.II ? "onAlertsEnabled" : "onAlertsDisabled"))));
            }
            else if (array.length > 1) {
                if (ii.II.contains(array[1].toLowerCase())) {
                    ii.II.remove(array[1].toLowerCase());
                    commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.ii(AlertFormatter.lI("onAlertsDisabled"))));
                }
                else {
                    ii.II.add(array[1].toLowerCase());
                    commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.ii(AlertFormatter.lI("onAlertsEnabled"))));
                }
            }
        }
        else {
            Checkable.logger.info(AlertFormatter.II() + "You can't execute this command in console");
        }
        return true;
    }
}
