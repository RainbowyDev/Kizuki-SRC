package kizuki.ac.packet;

import org.bukkit.entity.*;
import org.jetbrains.annotations.*;
import com.comphenix.protocol.events.*;

public abstract class Packet
{
    public final PacketEvent II;
    public final Player II;
    
    public Packet(final PacketEvent ii) {
        this.II = ii;
        this.II = ii.getPlayer();
    }
    
    public Packet(final Player ii) {
        this.II = null;
        this.II = ii;
    }
    
    @Nullable
    public PacketEvent II() {
        return this.II;
    }
    
    @NotNull
    public Player getPlayer() {
        return this.II;
    }
    
    public PacketContainer II() {
        return this.II.getPacket();
    }
}
