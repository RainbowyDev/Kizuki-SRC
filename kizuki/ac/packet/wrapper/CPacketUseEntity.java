package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import org.bukkit.entity.*;
import com.comphenix.protocol.events.*;

public class CPacketUseEntity extends Packet
{
    EnumWrappers$EntityUseAction action;
    int face;
    Entity entity;
    
    public CPacketUseEntity(final PacketEvent packetEvent) {
        super(packetEvent);
        this.action = (EnumWrappers$EntityUseAction)packetEvent.getPacket().getEntityUseActions().read(0);
        this.face = (int)packetEvent.getPacket().getIntegers().read(0);
        this.entity = (Entity)packetEvent.getPacket().getEntityModifier(packetEvent.getPlayer().getWorld()).read(0);
    }
    
    public EnumWrappers$EntityUseAction getAction() {
        return this.action;
    }
    
    public int getFace() {
        return this.face;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
    
    @Override
    public String toString() {
        return "ClientUseEntity{action=" + this.action + ", targetID=" + this.face + ", target=" + this.entity + '}';
    }
}
