package kizuki.ac;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import kizuki.ac.utils.gui.*;
import org.bukkit.event.*;

public class ll implements Listener
{
    @EventHandler
    public void II(final InventoryClickEvent inventoryClickEvent) {
        final String title = inventoryClickEvent.getView().getTitle();
        if (iI.II(title)) {
            final ChestButton ii = lI.II(inventoryClickEvent.getSlot(), iI.II(title).II());
            if (ii != null) {
                ii.II((Player)inventoryClickEvent.getView().getPlayer());
            }
            inventoryClickEvent.setCancelled(true);
        }
    }
}
