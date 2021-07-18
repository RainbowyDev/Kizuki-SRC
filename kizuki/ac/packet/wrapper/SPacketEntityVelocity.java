package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import com.comphenix.protocol.events.*;

public class SPacketEntityVelocity extends Packet
{
    VelocitySnapshot II;
    
    public SPacketEntityVelocity(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = new VelocitySnapshot((int)packetEvent.getPacket().getIntegers().read(1), (int)packetEvent.getPacket().getIntegers().read(2), (int)packetEvent.getPacket().getIntegers().read(3));
    }
    
    public VelocitySnapshot getVelocity() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ServerVelocity{velocity=" + this.II.toString() + '}';
    }
}
