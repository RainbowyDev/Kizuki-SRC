package kizuki.ac;

import kizuki.ac.packet.*;
import org.bukkit.inventory.*;
import com.comphenix.protocol.events.*;

public class ut extends Packet
{
    ItemStack II;
    
    public ut(final PacketEvent packetEvent) {
        super(packetEvent);
        this.II = (ItemStack)packetEvent.getPacket().getItemModifier().read(0);
    }
    
    public ItemStack II() {
        return this.II;
    }
    
    public short getId() {
        return (short)this.II.getPacket().getShorts().read(0);
    }
}
