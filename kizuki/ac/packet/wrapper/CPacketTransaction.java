package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;

public class CPacketTransaction extends Packet
{
    private final short II;
    
    public CPacketTransaction(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (short)this.II.getPacket().getShorts().read(0);
    }
    
    public short getId() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientTransaction{id=" + this.II + '}';
    }
}
