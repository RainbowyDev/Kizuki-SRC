package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.packet.*;

class tz extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    tz(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketSending(final PacketEvent packetEvent) {
        if (packetEvent.getPlayer().getEntityId() == (int)packetEvent.getPacket().getIntegers().read(0)) {
            PacketManager.II(new SPacketEntityVelocity(packetEvent));
        }
    }
}
