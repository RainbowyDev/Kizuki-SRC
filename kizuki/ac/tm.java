package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.*;

class tm extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    tm(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketReceiving(final PacketEvent packetEvent) {
        PacketManager.II(new ym(packetEvent));
    }
}
