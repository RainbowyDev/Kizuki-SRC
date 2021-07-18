package kizuki.ac;

import org.bukkit.entity.*;
import kizuki.ac.utils.gui.*;

public class rh extends ChestButton
{
    static final /* synthetic */ boolean II;
    
    public rh(final int n) {
        super(n - 1);
    }
    
    public rh(final int n, final int n2) {
        super((n - 1) * 9 + n2 - 1);
    }
    
    @Override
    public void II(final Player player) {
        final ChestGUI ii = rk.II();
        if (!rh.II && ii == null) {
            throw new AssertionError();
        }
        ii.II(player);
    }
    
    static {
        II = !rh.class.desiredAssertionStatus();
    }
}
