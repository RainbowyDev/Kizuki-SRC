package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.packet.*;

class tk extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    tk(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketReceiving(final PacketEvent packetEvent) {
        PacketManager.II(new CPacketArmAnimation(packetEvent));
    }
}
