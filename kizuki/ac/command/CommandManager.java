package kizuki.ac.command;

import kizuki.ac.check.*;
import org.jetbrains.annotations.*;
import org.bukkit.command.*;
import kizuki.ac.alert.*;
import kizuki.ac.command.impl.*;

public class CommandManager extends Checkable implements CommandExecutor
{
    public static AbstractCommand[] commands;
    
    public boolean onCommand(@NotNull final CommandSender commandSender, @NotNull final Command command, @NotNull final String s, @NotNull final String[] array) {
        if (commandSender.hasPermission("kizuki.cmd")) {
            if (array.length != 0) {
                for (final AbstractCommand abstractCommand : CommandManager.commands) {
                    if (abstractCommand.getCommand().equals(array[0])) {
                        return abstractCommand.handleCommand(commandSender, command, s, array);
                    }
                }
                commandSender.sendMessage(AlertFormatter.II(array[0]));
            }
            else {
                commandSender.sendMessage(AlertFormatter.II("none"));
            }
            return true;
        }
        return true;
    }
    
    static {
        CommandManager.commands = new AbstractCommand[] { new ThemeCommand(), new AlertsCommand(), new DebugCommand(), new CHelpCommand(), new GuiCommand(), new HelpCommand(), new InfoCommand(), new CfgReloadCommand(), new KickCommand(), new MessageCommand(), new BroadcastCommand(), new PacketLogCommand(), new ProfileCommand() };
    }
}
