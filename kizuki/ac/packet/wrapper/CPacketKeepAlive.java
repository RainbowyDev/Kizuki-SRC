package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;

public class CPacketKeepAlive extends Packet
{
    long id;
    
    public CPacketKeepAlive(final PacketEvent packetEvent) {
        super(packetEvent);
        if (BukkitEventListener2.II().equals(ServerVersions.iI)) {
            this.id = (int)packetEvent.getPacket().getIntegers().read(0);
        }
        else {
            this.id = (long)packetEvent.getPacket().getLongs().read(0);
        }
    }
    
    public long getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "ClientKeepAlive{id=" + this.id + '}';
    }
}
