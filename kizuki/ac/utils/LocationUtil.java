package kizuki.ac.utils;

import java.lang.reflect.*;
import kizuki.ac.*;
import kizuki.ac.event.*;
import org.bukkit.*;
import org.bukkit.block.*;
import java.util.*;

public class LocationUtil implements Cloneable
{
    Class clazz;
    private Method getCubesA;
    private Method getCubes;
    private World world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;
    
    public LocationUtil(final World world, final double x, final double y, final double z, final float yaw, final float pitch) {
        this.clazz = tw.II("AxisAlignedBB");
        try {
            if (BukkitEventListener2.II().equals(ServerVersions.iI)) {
                this.getCubesA = Objects.requireNonNull(tw.II("World")).getMethod("a", this.clazz);
            }
            else {
                this.getCubes = Objects.requireNonNull(tw.II("World")).getMethod("getCubes", tw.II("Entity"), this.clazz);
            }
        }
        catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public LocationUtil(final World world, final double x, final double y, final double z) {
        this.clazz = tw.II("AxisAlignedBB");
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public LocationUtil(final Location location) {
        this.clazz = tw.II("AxisAlignedBB");
        this.world = location.getWorld();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }
    
    public LocationUtil II() {
        return new LocationUtil(this.world, this.x, this.y, this.z, this.yaw, this.pitch);
    }
    
    public void II(final World world) {
        this.world = world;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setZ(final double z) {
        this.z = z;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public Block II() {
        return BlockUtils.getBlock(this);
    }
    
    public Location toLocation() {
        return new Location(this.world, this.x, this.y, this.z, this.yaw, this.pitch);
    }
    
    public boolean isFull() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.4, this.getY(), this.getZ() - 0.4, this.getX() + 0.4, this.getY() + 2.3, this.getZ() + 0.4);
            return BukkitEventListener2.II().equals(ServerVersions.iI) ? (((Collection)tw.II(this.getCubesA, invoke, instance)).size() != 0) : (((Collection)tw.II(this.getCubes, invoke, null, instance)).size() != 0);
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    boolean II(final double n) {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3 - n, this.getY(), this.getZ() - 0.3 - n, this.getX() + 0.3 + n, this.getY() + 1.8, this.getZ() + 0.3 + n);
            return BukkitEventListener2.II().equals(ServerVersions.iI) ? (((Collection)tw.II(this.getCubesA, invoke, instance)).size() > 0) : (((Collection)tw.II(this.getCubes, invoke, null, instance)).size() > 0);
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    public boolean iI() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3, this.getY() + 0.1, this.getZ() - 0.3, this.getX() + 0.3, this.getY() + 1.5, this.getZ() + 0.3);
            final Collection collection = (Collection)(BukkitEventListener2.II().equals(ServerVersions.iI) ? tw.II(this.getCubesA, invoke, instance) : ((Collection)tw.II(this.getCubes, invoke, null, instance)));
            return collection != null && collection.size() != 0;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public Collection II() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3, this.getY() + 0.1, this.getZ() - 0.3, this.getX() + 0.3, this.getY() + 1.5, this.getZ() + 0.3);
            return (Collection)(BukkitEventListener2.II().equals(ServerVersions.iI) ? tw.II(this.getCubesA, invoke, instance) : ((Collection)tw.II(this.getCubes, invoke, null, instance)));
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public boolean Ii() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.4, this.getY() + 2.0, this.getZ() - 0.4, this.getX() + 0.4, this.getY() - 0.4, this.getZ() + 0.4);
            final String concatanateStrings = CollectionUtils.concatanateStrings(BukkitEventListener2.II().equals(ServerVersions.iI) ? ((Collection)tw.II(this.getCubesA, invoke, instance)) : ((Collection)tw.II(this.getCubes, invoke, null, instance)));
            return concatanateStrings != null && concatanateStrings.toLowerCase().contains("web");
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public Collection iI() {
        return BlockUtils.getCollidedMaterials(this);
    }
    
    public boolean ii() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3, this.getY() - 0.75001, this.getZ() - 0.3, this.getX() + 0.3, this.getY() + 0.2, this.getZ() + 0.3);
            return BukkitEventListener2.II().equals(ServerVersions.iI) ? (((Collection)tw.II(this.getCubesA, invoke, instance)).size() > 0) : (((Collection)tw.II(this.getCubes, invoke, null, instance)).size() > 0);
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    public boolean ll() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3, this.getY() - 0.5001, this.getZ() - 0.3, this.getX() + 0.3, this.getY(), this.getZ() + 0.3);
            return BukkitEventListener2.II().equals(ServerVersions.iI) ? (((Collection)tw.II(this.getCubesA, invoke, instance)).size() > 0) : (((Collection)tw.II(this.getCubes, invoke, null, instance)).size() > 0);
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    public boolean isBoundingBoxEmptyTall() {
        try {
            final Object invoke = this.world.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(this.world, new Object[0]);
            final Object instance = this.clazz.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.getX() - 0.3, this.getY(), this.getZ() - 0.3, this.getX() + 0.3, this.getY() + 2.5001, this.getZ() + 0.3);
            return BukkitEventListener2.II().equals(ServerVersions.iI) ? (((Collection)tw.II(this.getCubesA, invoke, instance)).size() > 0) : (((Collection)tw.II(this.getCubes, invoke, null, instance)).size() > 0);
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    @Override
    public String toString() {
        return "LocationUtil{x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", world=" + this.world + '}';
    }
    
    public boolean isInLiquid() {
        final double n = 0.3;
        for (double n2 = -1.0; n2 <= 3.0; ++n2) {
            for (double n3 = -n; n3 <= n; n3 += n) {
                for (double n4 = -n; n4 <= n; n4 += n) {
                    final Block block = BlockUtils.getBlock(this.toLocation().clone().add(n3, n2, n4));
                    if (block != null) {
                        if (block.isLiquid()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
