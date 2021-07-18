package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.*;
import com.google.common.collect.*;
import kizuki.ac.event.*;
import kizuki.ac.packet.wrapper.*;

class yp extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    yp(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketReceiving(final PacketEvent packetEvent) {
        try {
            PacketManager.II(new CPacketTransaction(packetEvent));
            final short shortValue = (short)packetEvent.getPacket().getShorts().read(0);
            if (PacketManager.II.get(packetEvent.getPlayer()).containsKey((Object)shortValue)) {
                final long longValue = PacketManager.II.get(packetEvent.getPlayer()).get((Object)shortValue).get(0);
                final double n = (System.nanoTime() - longValue) / 1000000.0;
                PacketManager.II.get(packetEvent.getPlayer()).remove((Object)shortValue, (Object)longValue);
                BukkitEventListener2.II(packetEvent.getPlayer().getUniqueId()).II((int)n);
                PacketManager.II(new CPacketTickWTF(packetEvent.getPlayer(), n));
            }
        }
        catch (Exception ex) {}
    }
}
