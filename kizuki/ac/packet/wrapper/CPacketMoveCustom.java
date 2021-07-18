package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;

public class CPacketMoveCustom extends Packet
{
    double II;
    double iI;
    double Ii;
    float II;
    float iI;
    
    public CPacketMoveCustom(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (double)packetEvent.getPacket().getDoubles().read(0);
        this.iI = (double)packetEvent.getPacket().getDoubles().read(1);
        this.Ii = (double)packetEvent.getPacket().getDoubles().read(2);
    }
    
    public double getDeltaXZ() {
        return this.II;
    }
    
    public double getDeltaY() {
        return this.iI;
    }
    
    public double getDeltaX() {
        return this.Ii;
    }
    
    public float getDeltaPitch() {
        return this.II;
    }
    
    public float getDeltaYaw() {
        return this.iI;
    }
}
