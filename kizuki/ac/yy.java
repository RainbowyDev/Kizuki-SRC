package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.*;

class yy extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    yy(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketSending(final PacketEvent packetEvent) {
        PacketManager.II(new ua(packetEvent));
    }
}
