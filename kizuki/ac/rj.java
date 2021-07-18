package kizuki.ac;

import kizuki.ac.utils.gui.*;
import org.bukkit.entity.*;
import kizuki.ac.event.*;
import kizuki.ac.alert.*;
import java.util.*;

public class rj extends ChestButton
{
    public rj(final int n) {
        super(n - 1);
    }
    
    public rj(final int n, final int n2) {
        super((n - 1) * 9 + n2 - 1);
    }
    
    @Override
    public void II(final Player player) {
        try {
            BukkitEventListener2.II();
            player.sendMessage(tu.II("reloadedConfig").replace("%prefix%", AlertFormatter.II()));
        }
        catch (Exception ex) {
            player.sendMessage(AlertFormatter.translateColorCodes("&c Internal error -> " + ex + "\n&c" + Arrays.toString(ex.getStackTrace())));
        }
    }
}
