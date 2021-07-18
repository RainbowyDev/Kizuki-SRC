package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.entity.*;
import kizuki.ac.event.*;
import org.bukkit.*;
import java.util.*;
import kizuki.ac.alert.*;
import kizuki.ac.utils.*;
import kizuki.ac.data.*;
import kizuki.ac.*;

public class PacketLogCommand extends AbstractCommand
{
    public PacketLogCommand() {
        super("packetlog", "/kizuki packetlog <player-name>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        final String ii = MathUtil.II();
        if (array.length == 2) {
            BukkitEventListener2.II(((Player)commandSender).getUniqueId());
            PlayerData ii2;
            try {
                ii2 = BukkitEventListener2.II(Objects.requireNonNull(Bukkit.getPlayer(array[1])).getUniqueId());
            }
            catch (Exception ex2) {
                commandSender.sendMessage(tu.II("playerNotFound").replace("%player%", array[1]).replace("%prefix%", AlertFormatter.II()));
                return true;
            }
            if (!(ii2.iI = !ii2.iI)) {
                try {
                    final qw qw = new qw();
                    final LL ii3 = qw.II(ii);
                    final qd ii4 = qw.II();
                    ii4.iI("PacketLog [" + array[1] + "] [id" + RandomUtils.randomInt(Integer.MAX_VALUE) + "]");
                    ii4.ll(ii2.II);
                    ii4.ii("text");
                    ii4.II(qg.Ii);
                    ii4.II(qf.iI);
                    final qk ii5 = ii3.II(ii4.II());
                    if (ii5.II()) {
                        System.out.println("Something wrong: " + ii5.II());
                        return false;
                    }
                    commandSender.sendMessage(AlertFormatter.translateColorCodes("&c Completed. -> " + (String)ii5.II()));
                    ii2.II = "";
                }
                catch (Exception ex) {
                    commandSender.sendMessage(ex.getMessage());
                }
            }
            else {
                commandSender.sendMessage(AlertFormatter.translateColorCodes("&c Started. "));
            }
            return true;
        }
        commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI("wrongNumberOfArguments").replace("%prefix%", AlertFormatter.II()).replace("%exp%", "2").replace("%args_length%", array.length + "")));
        return true;
    }
}
