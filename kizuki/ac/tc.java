package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.*;

class tc extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    tc(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketSending(final PacketEvent packetEvent) {
        PacketManager.II(new uu(packetEvent));
    }
}
