package kizuki.ac;

import org.bukkit.entity.*;
import kizuki.ac.check.*;
import kizuki.ac.check.enums.*;
import kizuki.ac.event.*;
import java.util.*;
import kizuki.ac.alert.*;
import kizuki.ac.utils.gui.*;

final class rz extends ChestButton
{
    static final /* synthetic */ boolean II;
    final /* synthetic */ rm II;
    
    rz(final int n, final rm ii) {
        this.II = ii;
        super(n);
    }
    
    @Override
    public void II(final Player player) {
        try {
            Checkable.II().set(CheckType.iI(this.II.II) + "." + this.II.II + ".enabled", (Object)!config.II(CheckType.iI(this.II.II) + "." + this.II.II + ".enabled"));
            Checkable.iI.iI();
            BukkitEventListener2.II();
            final ChestGUI ii = rk.II(this.II.II);
            if (!rz.II && ii == null) {
                throw new AssertionError();
            }
            ii.II(player);
        }
        catch (Exception ex) {
            player.sendMessage(AlertFormatter.translateColorCodes("&c Internal error -> " + ex + "\n&c" + Arrays.toString(ex.getStackTrace())));
        }
    }
    
    static {
        II = !rk.class.desiredAssertionStatus();
    }
}
