package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import com.comphenix.protocol.events.*;

public class CPacketEntityAction extends Packet
{
    private final EnumWrappers$PlayerAction II;
    
    public CPacketEntityAction(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (EnumWrappers$PlayerAction)packetEvent.getPacket().getPlayerActions().read(0);
    }
    
    public EnumWrappers$PlayerAction getAction() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientAction{action=" + this.II + '}';
    }
}
