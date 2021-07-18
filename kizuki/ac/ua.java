package kizuki.ac;

import kizuki.ac.packet.*;
import com.comphenix.protocol.*;
import org.bukkit.entity.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;

public class ua extends Packet
{
    final PacketType II;
    final Entity II;
    final boolean II;
    final double II;
    final double iI;
    final double Ii;
    
    public ua(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = packetEvent.getPacketType();
        this.II = BlockUtils.getEntityById(packetEvent.getPlayer().getWorld(), (int)packetEvent.getPacket().getIntegers().read(0));
        this.II = (boolean)this.II().getBooleans().read(0);
        if (BukkitEventListener2.II() == ServerVersions.iI) {
            this.II = (int)this.II().getIntegers().read(0) / 32.0;
            this.iI = (int)this.II().getIntegers().read(1) / 32.0;
            this.Ii = (int)this.II().getIntegers().read(2) / 32.0;
        }
        else {
            this.II = (double)this.II().getDoubles().read(0);
            this.iI = (double)this.II().getDoubles().read(1);
            this.Ii = (double)this.II().getDoubles().read(2);
        }
    }
    
    public Entity getEntity() {
        return this.II;
    }
    
    public boolean isMathematicallyGround() {
        return this.II;
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
