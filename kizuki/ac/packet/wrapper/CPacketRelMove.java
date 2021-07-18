package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import org.bukkit.entity.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.utils.*;
import com.comphenix.protocol.*;
import kizuki.ac.event.*;

public class CPacketRelMove extends Packet
{
    final PacketType II;
    final Entity II;
    float II;
    float iI;
    double II;
    double iI;
    double Ii;
    
    public CPacketRelMove(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = 0.0f;
        this.iI = 0.0f;
        this.II = 0.0;
        this.iI = 0.0;
        this.Ii = 0.0;
        this.II = packetEvent.getPacketType();
        this.II = BlockUtils.getEntityById(packetEvent.getPlayer().getWorld(), (int)packetEvent.getPacket().getIntegers().read(0));
        if (packetEvent.getPacketType().equals((Object)PacketType$Play$Server.REL_ENTITY_MOVE_LOOK) || packetEvent.getPacketType().equals((Object)PacketType$Play$Server.REL_ENTITY_MOVE)) {
            if (BukkitEventListener2.II().II() == 47) {
                this.II = (byte)this.II().getBytes().read(0) / 32.0;
                this.iI = (byte)this.II().getBytes().read(1) / 32.0;
                this.Ii = (byte)this.II().getBytes().read(2) / 32.0;
            }
            else {
                this.II = (int)this.II().getIntegers().read(1) / 32.0;
                this.iI = (int)this.II().getIntegers().read(2) / 32.0;
                this.Ii = (int)this.II().getIntegers().read(3) / 32.0;
            }
        }
        if (packetEvent.getPacketType().equals((Object)PacketType$Play$Server.REL_ENTITY_MOVE_LOOK) || packetEvent.getPacketType().equals((Object)PacketType$Play$Server.ENTITY_LOOK)) {
            this.II = (byte)packetEvent.getPacket().getBytes().read(0) * 360.0f / 256.0f;
            this.iI = (byte)packetEvent.getPacket().getBytes().read(0) * 360.0f / 256.0f;
        }
        else if (this.II != null) {
            this.II = this.II.getLocation().getYaw();
            this.iI = this.II.getLocation().getPitch();
        }
    }
    
    public Entity getEntity() {
        return this.II;
    }
    
    public float getDeltaPitch() {
        return this.II;
    }
    
    public float getDeltaYaw() {
        return this.iI;
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
}
