package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import org.bukkit.entity.*;
import kizuki.ac.event.*;
import org.bukkit.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import kizuki.ac.data.*;
import kizuki.ac.check.*;

public class ProfileCommand extends AbstractCommand
{
    public ProfileCommand() {
        super("profile", "/kizuki profile <player-name>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        if (array.length == 2) {
            BukkitEventListener2.II(((Player)commandSender).getUniqueId());
            final String lowerCase = array[1].toLowerCase();
            try {
                final Player player = Bukkit.getPlayer(lowerCase);
                if (player == null) {
                    throw new NullPointerException();
                }
                final PlayerData ii = BukkitEventListener2.II(player.getUniqueId());
                if (ii == null) {
                    throw new NullPointerException();
                }
                String s2 = tu.II("profile").replace("%player%", player.getName()).replace("%ip%", player.getAddress().getAddress().toString()).replace("%vpn%", "" + (player.getAddress().getAddress().getHostName().isEmpty() || player.getAddress().getHostName().equals(player.getAddress().getAddress().getHostAddress()))).replace("%sensitivity%", String.valueOf(ii.qp)).replace("%ping%", String.valueOf(ii.II)).replace("%version%", String.valueOf(ii.II).replace("_", "."));
                if (s2.contains("%flags%")) {
                    final StringBuilder sb = new StringBuilder();
                    for (final KizukiCheck kizukiCheck : ii.checks) {
                        if (kizukiCheck.II().getMin() != kizukiCheck.II().getValue()) {
                            sb.append(tu.II("profileflag").replace("%player%", player.getName()).replace("%checkname%", kizukiCheck.II()).replace("%lcheck%", kizukiCheck.II().split(" ")[0]).replace("%letter%", kizukiCheck.II().split(" ")[1].replace("(", "").replace(")", "")).replace("%vl%", AlertFormatter.round(kizukiCheck.II().getValue(), AlertFormatter.getRoundPlaces()) + ""));
                        }
                    }
                    s2 = s2.replace("%flags%", (sb.toString().length() != 0) ? sb.toString() : ("&7 - " + tu.II("noinfo")));
                }
                commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.ii(s2)));
                return true;
            }
            catch (NullPointerException ex) {
                commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.ii(tu.II("playerNotFound"))));
                return true;
            }
        }
        commandSender.sendMessage(AlertFormatter.translateColorCodes(AlertFormatter.lI("wrongNumberOfArguments").replace("%prefix%", AlertFormatter.II()).replace("%exp%", "2").replace("%args_length%", array.length + "")));
        return true;
    }
}
