package kizuki.ac.utils;

import org.bukkit.util.*;
import kizuki.ac.*;

public class Box
{
    private final Vector x;
    private final Vector iI;
    private final Vector Ii;
    private final double II;
    private final double iI;
    private final double Ii;
    
    public Box(final uv uv, final Vector vector, final double n) {
        this.II = Math.abs(uv.II - uv.ii) + n;
        this.iI = Math.abs(uv.iI - uv.ll) + n;
        this.Ii = Math.abs(uv.Ii - uv.lI) + n;
        this.x = new Vector(-this.II / 2.0 - n + vector.getX(), 0.0 - n + vector.getY(), -this.Ii / 2.0 - n + vector.getZ());
        this.iI = new Vector(this.II / 2.0 + n + vector.getX(), this.iI + n + vector.getY(), this.Ii / 2.0 + n + vector.getZ());
        this.Ii = this.x.clone().add(this.iI).divide(new Vector(2, 2, 2));
    }
    
    public Box(final uv uv) {
        this.II = Math.abs(uv.II - uv.ii);
        this.iI = Math.abs(uv.iI - uv.ll);
        this.Ii = Math.abs(uv.Ii - uv.lI);
        this.x = new Vector(Math.min(uv.II, uv.ii), Math.min(uv.iI, uv.ll), Math.min(uv.Ii, uv.lI));
        this.iI = new Vector(Math.max(uv.II, uv.ii), Math.max(uv.iI, uv.ll), Math.max(uv.Ii, uv.lI));
        this.Ii = this.x.clone().add(this.iI).divide(new Vector(2, 2, 2));
    }
    
    public Vector II() {
        return this.iI;
    }
    
    public Vector iI() {
        return this.x;
    }
    
    public double getDistance(final Vector vector) {
        final double max = Math.max(this.x.getX() - vector.getX(), Math.max(0.0, vector.getX() - this.iI.getX()));
        final double max2 = Math.max(this.x.getY() - vector.getY(), Math.max(0.0, vector.getY() - this.iI.getY()));
        final double max3 = Math.max(this.x.getZ() - vector.getZ(), Math.max(0.0, vector.getZ() - this.iI.getZ()));
        return Math.sqrt(max * max + max2 * max2 + max3 * max3);
    }
    
    @Override
    public String toString() {
        return "Box{min=" + this.x.toString() + ", max=" + this.iI.toString() + ", pos=" + this.Ii.toString() + ", w=" + this.II + ", h=" + this.iI + ", d=" + this.Ii + '}';
    }
    
    public boolean II(final Box box) {
        return Math.abs(this.Ii.getX() - box.Ii.getX()) < this.II / 2.0 + box.II / 2.0 && Math.abs(this.Ii.getY() - box.Ii.getY()) < this.iI / 2.0 + box.iI / 2.0 && Math.abs(this.Ii.getZ() - box.Ii.getZ()) < this.Ii / 2.0 + box.Ii / 2.0;
    }
    
    public boolean isCollide(final Vector vector) {
        return this.x.getX() < vector.getX() && this.x.getY() < vector.getY() && this.x.getZ() < vector.getZ() && this.iI.getX() > vector.getX() && this.iI.getY() > vector.getY() && this.iI.getZ() > vector.getZ();
    }
    
    public Vector getIntercept(final Ray ray, final float n, final float n2) {
        final Vector vector = new Vector(1.0 / ray.getDirection().getX(), 1.0 / ray.getDirection().getY(), 1.0 / ray.getDirection().getZ());
        final boolean b = vector.getX() < 0.0;
        final boolean b2 = vector.getY() < 0.0;
        final boolean b3 = vector.getZ() < 0.0;
        double n3 = ((b ? this.iI : this.x).getX() - ray.getOrigin().getX()) * vector.getX();
        double n4 = ((b ? this.x : this.iI).getX() - ray.getOrigin().getX()) * vector.getX();
        final double n5 = ((b2 ? this.iI : this.x).getY() - ray.getOrigin().getY()) * vector.getY();
        final double n6 = ((b2 ? this.x : this.iI).getY() - ray.getOrigin().getY()) * vector.getY();
        if (n3 > n6 || n5 > n4) {
            return null;
        }
        if (n5 > n3) {
            n3 = n5;
        }
        if (n6 < n4) {
            n4 = n6;
        }
        final double n7 = ((b3 ? this.iI : this.x).getZ() - ray.getOrigin().getZ()) * vector.getZ();
        final double n8 = ((b3 ? this.x : this.iI).getZ() - ray.getOrigin().getZ()) * vector.getZ();
        if (n3 > n8 || n7 > n4) {
            return null;
        }
        if (n7 > n3) {
            n3 = n7;
        }
        if (n8 < n4) {
            n4 = n8;
        }
        if (n3 < n2 && n4 > n) {
            return ray.II(n3);
        }
        return null;
    }
}
