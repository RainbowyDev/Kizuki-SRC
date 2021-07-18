package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import com.comphenix.protocol.events.*;

public class CPacketDig extends Packet
{
    EnumWrappers$PlayerDigType II;
    BlockPosition II;
    
    public CPacketDig(final PacketEvent packetEvent) {
        super(packetEvent);
        try {
            this.II = (BlockPosition)packetEvent.getPacket().getBlockPositionModifier().read(0);
        }
        catch (Exception ex) {
            this.II = null;
        }
        this.II = (EnumWrappers$PlayerDigType)packetEvent.getPacket().getPlayerDigTypes().read(0);
    }
    
    public EnumWrappers$PlayerDigType getDigType() {
        return this.II;
    }
    
    public BlockPosition getBlockPosition() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientBlockDig{action=" + this.II + ", location=" + this.II + '}';
    }
}
