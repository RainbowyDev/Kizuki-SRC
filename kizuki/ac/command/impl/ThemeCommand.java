package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import kizuki.ac.check.*;
import kizuki.ac.event.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import java.util.*;

public class ThemeCommand extends AbstractCommand
{
    public ThemeCommand() {
        super("theme", "/kizuki theme");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        final Set keys = Checkable.iI().getKeys(false);
        keys.remove("style");
        if (array.length == 2) {
            if (keys.contains(array[1])) {
                Checkable.iI().set("style", (Object)array[1]);
                Checkable.II.iI();
                BukkitEventListener2.II();
                commandSender.sendMessage(tu.II("reloadedConfig").replace("%prefix%", AlertFormatter.II()));
            }
            else {
                commandSender.sendMessage(tu.II("unknownThemeOrNotEnoughArgs").replace("%prefix%", AlertFormatter.II()).replace("%available_themes%", keys.toString()).replace("%arg%", array[1]));
            }
        }
        else {
            commandSender.sendMessage(tu.II("unknownThemeOrNotEnoughArgs").replace("%prefix%", AlertFormatter.II()).replace("%available_themes%", keys.toString()).replace("%arg%", "none"));
        }
        return true;
    }
}
