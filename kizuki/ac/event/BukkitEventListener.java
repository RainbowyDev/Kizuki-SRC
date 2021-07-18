package kizuki.ac.event;

import org.bukkit.event.player.*;
import kizuki.ac.api.*;
import org.bukkit.event.*;

public class BukkitEventListener implements Listener
{
    @EventHandler
    public void onPlayerRespawn(final PlayerRespawnEvent playerRespawnEvent) {
        BukkitEventListener2.II(playerRespawnEvent.getPlayer().getUniqueId()).iI = 0;
        BukkitEventListener2.II(playerRespawnEvent.getPlayer().getUniqueId()).time = System.currentTimeMillis();
    }
    
    @EventHandler
    public void onPlayerTeleport(final PlayerTeleportEvent playerTeleportEvent) {
        if (playerTeleportEvent.getCause().equals((Object)PlayerTeleportEvent$TeleportCause.NETHER_PORTAL) || playerTeleportEvent.getCause().equals((Object)PlayerTeleportEvent$TeleportCause.END_PORTAL) || playerTeleportEvent.getCause().equals((Object)PlayerTeleportEvent$TeleportCause.PLUGIN)) {
            BukkitEventListener2.II(playerTeleportEvent.getPlayer().getUniqueId()).II = System.currentTimeMillis();
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onKizukiFlagEvent(final KizukiACFlagEvent kizukiACFlagEvent) {
        if (!kizukiACFlagEvent.isCancelled()) {
            BukkitEventListener2.II(kizukiACFlagEvent.getCheckAPI(), kizukiACFlagEvent.getMultiplier(), BukkitEventListener2.II(kizukiACFlagEvent.getPlayer().getUniqueId()), kizukiACFlagEvent.getVerbose());
        }
    }
}
