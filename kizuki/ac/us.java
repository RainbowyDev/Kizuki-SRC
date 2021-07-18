package kizuki.ac;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;

public class us extends Packet
{
    long II;
    
    public us(final PacketEvent packetEvent) {
        super(packetEvent);
        if (BukkitEventListener2.II().equals(ServerVersions.iI)) {
            this.II = (int)packetEvent.getPacket().getIntegers().read(0);
        }
        else {
            this.II = (long)packetEvent.getPacket().getLongs().read(0);
        }
    }
    
    public long getId() {
        return this.II;
    }
}
