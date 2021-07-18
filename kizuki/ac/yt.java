package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.packet.*;

class yt extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    yt(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketSending(final PacketEvent packetEvent) {
        PacketManager.II(new CPacketRelMove(packetEvent));
    }
}
