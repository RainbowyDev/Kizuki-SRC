package kizuki.ac.event;

import org.bukkit.event.block.*;
import kizuki.ac.utils.block.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class BukkitEventListener3 implements Listener
{
    @EventHandler(priority = EventPriority.MONITOR)
    public void II(final BlockPlaceEvent blockPlaceEvent) {
        if (blockPlaceEvent.isCancelled()) {
            final Block block = blockPlaceEvent.getBlock();
            BukkitEventListener2.II(blockPlaceEvent.getPlayer().getUniqueId()).velocity.add(new KizukiBlock(block.getType(), block.getX(), block.getY(), block.getZ()));
        }
    }
}
