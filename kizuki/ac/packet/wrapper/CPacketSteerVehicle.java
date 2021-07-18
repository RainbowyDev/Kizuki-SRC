package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;

public class CPacketSteerVehicle extends Packet
{
    private final float II;
    private final float iI;
    private final boolean II;
    private final boolean iI;
    
    public CPacketSteerVehicle(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (float)packetEvent.getPacket().getFloat().read(0);
        this.iI = (float)packetEvent.getPacket().getFloat().read(1);
        this.II = (boolean)packetEvent.getPacket().getBooleans().read(0);
        this.iI = (boolean)packetEvent.getPacket().getBooleans().read(0);
    }
    
    public float getDeltaPitch() {
        return this.II;
    }
    
    public float getDeltaYaw() {
        return this.iI;
    }
    
    public boolean isMathematicallyGround() {
        return this.II;
    }
    
    public boolean isGround() {
        return this.iI;
    }
}
