package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.packet.*;
import java.util.*;

class yw extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    yw(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketReceiving(final PacketEvent packetEvent) {
        if (packetEvent.getPlayer() == null) {
            return;
        }
        final UUID uniqueId = packetEvent.getPlayer().getUniqueId();
        final CPacketFlying cPacketFlying = new CPacketFlying(packetEvent, this.II.iI.get(uniqueId));
        this.II.iI.put(uniqueId, new LocationUtil(packetEvent.getPlayer().getWorld(), cPacketFlying.getTo().getX(), cPacketFlying.getTo().getY(), cPacketFlying.getTo().getZ(), cPacketFlying.getTo().getYaw(), cPacketFlying.getTo().getPitch()));
        PacketManager.II(cPacketFlying);
    }
}
