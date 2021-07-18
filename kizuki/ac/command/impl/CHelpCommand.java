package kizuki.ac.command.impl;

import org.bukkit.command.*;
import org.jetbrains.annotations.*;
import kizuki.ac.command.*;
import kizuki.ac.*;
import kizuki.ac.alert.*;

public class CHelpCommand extends AbstractCommand
{
    public CHelpCommand() {
        super("chelp", "/kizuki chelp <plugin-subcommand>");
    }
    
    @Override
    public boolean handleCommand(final CommandSender commandSender, @NotNull final Command command, final String s, final String[] array) {
        if (array.length == 2) {
            final String lowerCase = array[1].toLowerCase();
            for (final AbstractCommand abstractCommand : CommandManager.commands) {
                if (abstractCommand.getCommand().equals(lowerCase)) {
                    commandSender.sendMessage(AlertFormatter.translateColorCodes(tu.II("commmandhelp").replace("%prefix%", AlertFormatter.II()).replace("%command%", lowerCase).replace("%syntax%", abstractCommand.getUsage())));
                    return true;
                }
            }
            commandSender.sendMessage(AlertFormatter.II(array[1]));
            return true;
        }
        commandSender.sendMessage(AlertFormatter.translateColorCodes(tu.II("commmandhelp").replace("%prefix%", AlertFormatter.II()).replace("%command%", "chelp").replace("%syntax%", this.getUsage())));
        return true;
    }
}
