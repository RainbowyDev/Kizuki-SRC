package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;
import org.jetbrains.annotations.*;

public class CPacketBlockPlace extends Packet
{
    public final BlockPosition blockPosition;
    public final int face;
    
    public CPacketBlockPlace(final PacketEvent packetEvent) {
        super(packetEvent);
        if (BukkitEventListener2.II().II() == ServerVersions.iI.II()) {
            this.blockPosition = this.getBlockPosition();
        }
        else {
            this.blockPosition = null;
        }
        this.face = this.getFace();
    }
    
    @Nullable
    public BlockPosition getBlockPosition() {
        try {
            if (this.II().getPacket() == null) {
                return null;
            }
            return (BlockPosition)this.II().getPacket().getBlockPositionModifier().read(0);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public int getFace() {
        try {
            return (int)this.II().getPacket().getIntegers().read(0) & 0xF;
        }
        catch (Exception ex) {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "ClientBlockPlace{blockPos=" + this.blockPosition + ", face=" + this.face + '}';
    }
}
