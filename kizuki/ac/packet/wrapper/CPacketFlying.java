package kizuki.ac.packet.wrapper;

import kizuki.ac.packet.*;
import org.bukkit.*;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.*;
import kizuki.ac.data.*;
import kizuki.ac.event.*;
import org.jetbrains.annotations.*;
import org.apache.commons.lang.*;
import kizuki.ac.*;
import kizuki.ac.utils.*;
import java.util.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;

public class CPacketFlying extends Packet
{
    boolean world;
    LocationUtil from;
    LocationUtil to;
    boolean ground;
    boolean bool;
    boolean look;
    boolean pos;
    double deltaXZ;
    double deltaY;
    double deltaX;
    double deltaZ;
    float deltaPitch;
    float deltaYaw;
    World world;
    Player player;
    
    public CPacketFlying(final PacketEvent packetEvent, final LocationUtil from) {
        super(packetEvent);
        this.player = packetEvent.getPlayer();
        this.world = this.player.getWorld();
        if (from == null) {
            this.from = new LocationUtil(packetEvent.getPlayer().getLocation());
        }
        else {
            this.from = from;
        }
        if (packetEvent.getPacketType().equals((Object)PacketType$Play$Client.FLYING)) {
            this.to = this.from;
        }
        else if (packetEvent.getPacketType().equals((Object)PacketType$Play$Client.POSITION)) {
            this.to = new LocationUtil(this.world, (double)packetEvent.getPacket().getDoubles().read(0), (double)packetEvent.getPacket().getDoubles().read(1), (double)packetEvent.getPacket().getDoubles().read(2), this.from.getYaw(), this.from.getPitch());
            this.pos = true;
        }
        else if (packetEvent.getPacketType().equals((Object)PacketType$Play$Client.POSITION_LOOK)) {
            this.to = new LocationUtil(this.world, (double)packetEvent.getPacket().getDoubles().read(0), (double)packetEvent.getPacket().getDoubles().read(1), (double)packetEvent.getPacket().getDoubles().read(2), (float)packetEvent.getPacket().getFloat().read(0), (float)packetEvent.getPacket().getFloat().read(1));
            this.pos = true;
            this.look = true;
        }
        else if (packetEvent.getPacketType().equals((Object)PacketType$Play$Client.LOOK)) {
            this.to = new LocationUtil(this.world, this.from.getX(), this.from.getY(), this.from.getZ(), (float)packetEvent.getPacket().getFloat().read(0), (float)packetEvent.getPacket().getFloat().read(1));
            this.look = true;
        }
        this.ground = (boolean)packetEvent.getPacket().getBooleans().read(0);
        this.deltaX = Math.abs(this.to.getX() - this.from.getX());
        this.deltaZ = Math.abs(this.to.getZ() - this.from.getZ());
        this.deltaXZ = MathUtil.Ii(this.deltaX, this.deltaZ);
        this.deltaY = this.to.getY() - this.from.getY();
        this.deltaPitch = this.to.getPitch() - this.from.getPitch();
        this.deltaYaw = Math.abs(this.to.getYaw() - this.from.getYaw());
        this.world = this.qq();
        this.bool = this.LL();
    }
    
    public PlayerData II() {
        return BukkitEventListener2.II(this.player.getUniqueId());
    }
    
    public boolean isMathematicallyGround() {
        return this.getTo().getY() % 0.015625 == 0.0 || this.getFrom().getY() % 0.015625 == 0.0;
    }
    
    public LocationUtil getFrom() {
        return this.from;
    }
    
    public LocationUtil getTo() {
        return this.to;
    }
    
    public boolean isGround() {
        return this.ground;
    }
    
    public boolean isLook() {
        return this.look;
    }
    
    public boolean isPos() {
        return this.pos;
    }
    
    public double getDeltaXZ() {
        return this.deltaXZ;
    }
    
    public double getDeltaY() {
        return this.deltaY;
    }
    
    public double getDeltaX() {
        return this.deltaX;
    }
    
    public double getDeltaZ() {
        return this.deltaZ;
    }
    
    public float getDeltaPitch() {
        return this.deltaPitch;
    }
    
    public float getDeltaYaw() {
        return this.deltaYaw;
    }
    
    public boolean isInverse() {
        return this.from.getYaw() < this.to.getYaw();
    }
    
    public World getWorld() {
        return this.world;
    }
    
    @NotNull
    @Override
    public Player getPlayer() {
        return this.player;
    }
    
    public boolean getWorld() {
        return this.world;
    }
    
    public boolean isCollidingWithEntity() {
        return this.bool;
    }
    
    boolean LL() {
        for (final Entity entity : this.world.getNearbyEntities(this.to.toLocation(), 4.0, 6.0, 4.0)) {
            if (entity instanceof Boat) {
                if (entity.getUniqueId().equals(this.player.getUniqueId())) {
                    continue;
                }
                int n = 0;
                final Vector[] ii = ih.II(entity.getUniqueId());
                ArrayUtils.reverse((Object[])ii);
                for (final Vector vector : ii) {
                    ++n;
                    final int n2 = (int)Math.ceil(this.II().II() / 50.0);
                    if (n >= n2) {
                        if (n > n2 + 4) {
                            break;
                        }
                        if (new Box(Objects.requireNonNull(tw.II(entity)), vector, 0.1).II(new Box(new uv(-0.3, 0.0, -0.3, 0.3, 1.8, 0.3), this.to.toLocation().toVector(), 0.1))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    boolean qq() {
        try {
            for (final Entity entity : this.world.getNearbyEntities(this.to.toLocation(), 7.0, 7.0, 7.0)) {
                try {
                    if (!(entity instanceof LivingEntity)) {
                        continue;
                    }
                    if (entity.getUniqueId().equals(this.getPlayer().getUniqueId())) {
                        continue;
                    }
                    int n = 0;
                    final Vector[] ii = ih.II(entity.getUniqueId());
                    ArrayUtils.reverse((Object[])ii);
                    for (final Vector vector : ii) {
                        ++n;
                        final int n2 = (int)Math.ceil(this.II().II() / 50.0);
                        if (n >= n2) {
                            if (n > n2 + 4) {
                                break;
                            }
                            final uv ii2 = tw.II(entity);
                            if (ii2 == null || vector == null) {
                                return true;
                            }
                            if (new Box(ii2, vector, 0.0).II(new Box(new uv(-0.3, 0.0, -0.3, 0.3, 1.8, 0.3), this.to.toLocation().toVector(), 0.1))) {
                                return true;
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    return false;
                }
            }
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return false;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "ClientFlying{isPushed=" + this.world + ", from=" + this.from + ", to=" + this.to + ", isOnGround=" + this.ground + ", hasLook=" + this.look + ", hasPos=" + this.pos + ", deltaXZ=" + this.deltaXZ + ", deltaY=" + this.deltaY + ", deltaX=" + this.deltaX + ", deltaZ=" + this.deltaZ + ", deltaPitch=" + this.deltaPitch + ", deltaYaw=" + this.deltaYaw + ", world=" + this.world + ", player=" + this.player + '}';
    }
}
