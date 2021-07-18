package kizuki.ac;

import kizuki.ac.check.enums.*;
import org.bukkit.entity.*;
import kizuki.ac.utils.gui.*;

final class rc extends ChestButton
{
    static final /* synthetic */ boolean II;
    final /* synthetic */ CheckType II;
    
    rc(final int n, final CheckType ii) {
        this.II = ii;
        super(n);
    }
    
    @Override
    public void II(final Player player) {
        final ChestGUI ii = rk.II(this.II);
        if (!rc.II && ii == null) {
            throw new AssertionError();
        }
        ii.II(player);
    }
    
    static {
        II = !rk.class.desiredAssertionStatus();
    }
}
