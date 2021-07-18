package kizuki.ac;

import org.bukkit.entity.*;
import kizuki.ac.utils.gui.*;

final class rl extends ChestButton
{
    static final /* synthetic */ boolean II;
    
    rl(final int n) {
        super(n);
    }
    
    @Override
    public void II(final Player player) {
        final ChestGUI ii = rk.II();
        if (!rl.II && ii == null) {
            throw new AssertionError();
        }
        ii.II(player);
    }
    
    static {
        II = !rk.class.desiredAssertionStatus();
    }
}
