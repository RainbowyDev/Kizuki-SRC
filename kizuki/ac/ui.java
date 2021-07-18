package kizuki.ac;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;

public class ui extends Packet
{
    private final boolean II;
    private final boolean iI;
    private final boolean Ii;
    private final boolean ii;
    
    public ui(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (boolean)packetEvent.getPacket().getBooleans().read(0);
        this.iI = (boolean)packetEvent.getPacket().getBooleans().read(1);
        this.Ii = (boolean)packetEvent.getPacket().getBooleans().read(2);
        this.ii = (boolean)packetEvent.getPacket().getBooleans().read(3);
    }
    
    public boolean isMathematicallyGround() {
        return this.II;
    }
    
    public boolean isGround() {
        return this.iI;
    }
    
    public boolean isLook() {
        return this.Ii;
    }
    
    public boolean isPos() {
        return this.ii;
    }
}
