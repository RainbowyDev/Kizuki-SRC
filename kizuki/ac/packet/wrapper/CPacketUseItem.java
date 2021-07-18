package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import com.comphenix.protocol.events.*;

public class CPacketUseItem extends Packet
{
    BlockPosition II;
    EnumWrappers$Direction II;
    
    public CPacketUseItem(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (BlockPosition)this.II().getBlockPositionModifier().read(0);
        this.II = (EnumWrappers$Direction)this.II().getDirections().read(0);
    }
    
    public BlockPosition getBlockPosition() {
        return this.II;
    }
    
    public EnumWrappers$Direction getDirection() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientUseItem{location=" + this.II + ", face=" + this.II + '}';
    }
}
