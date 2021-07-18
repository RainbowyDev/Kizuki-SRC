package kizuki.ac;

import kizuki.ac.utils.gui.*;
import org.bukkit.entity.*;

final class rb extends ChestButton
{
    rb(final int n) {
        super(n);
    }
    
    @Override
    public void II(final Player player) {
        player.closeInventory();
    }
}
