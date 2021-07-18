package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import org.bukkit.entity.*;

public class CPacketTickWTF extends Packet
{
    private final double II;
    
    public CPacketTickWTF(final Player player, final double ii) {
        super(player);
        this.II = ii;
    }
    
    public double getDeltaXZ() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "ClientTick{ping=" + this.II + '}';
    }
}
