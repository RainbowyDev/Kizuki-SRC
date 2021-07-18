package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;

public class CHeldItemSlot extends Packet
{
    int II;
    
    public CHeldItemSlot(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (int)this.II().getIntegers().read(0);
    }
    
    public int getFace() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientSlotChange{slot=" + this.II + '}';
    }
}
