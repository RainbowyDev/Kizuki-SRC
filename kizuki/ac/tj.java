package kizuki.ac;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import org.bukkit.*;
import kizuki.ac.check.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.packet.*;

class tj extends PacketAdapter
{
    final /* synthetic */ PacketManager II;
    
    tj(final PacketManager ii, final Plugin plugin, final ListenerPriority listenerPriority, final PacketType... array) {
        this.II = ii;
        super(plugin, listenerPriority, array);
    }
    
    public void onPacketReceiving(final PacketEvent packetEvent) {
        if ((int)packetEvent.getPacket().getIntegers().read(0) < 0) {
            Bukkit.getScheduler().callSyncMethod(Checkable.plugin, () -> {
                packetEvent.getPlayer().kickPlayer("null");
                return null;
            });
            return;
        }
        PacketManager.II(new CPacketUseEntity(packetEvent));
    }
}
