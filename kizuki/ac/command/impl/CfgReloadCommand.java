package kizuki.ac.command.impl;

import kizuki.ac.command.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import kizuki.ac.event.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;
import java.util.*;

public class CfgReloadCommand extends AbstractCommand
{
    public CfgReloadCommand() {
        super("cfgreload", "/kizuki cfgreload");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        try {
            BukkitEventListener2.II();
            commandSender.sendMessage(tu.II("reloadedConfig").replace("%prefix%", AlertFormatter.II()));
        }
        catch (Exception ex) {
            commandSender.sendMessage(AlertFormatter.translateColorCodes("&c Internal error -> " + ex + "\n&c" + Arrays.toString(ex.getStackTrace())));
            return false;
        }
        return true;
    }
}
