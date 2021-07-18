package kizuki.ac.utils;

import org.bukkit.util.*;

public class VelocitySnapshot
{
    double II;
    double iI;
    double Ii;
    
    public VelocitySnapshot(final double n, final double n2, final double n3) {
        this.II = n / 8000.0;
        this.iI = n2 / 8000.0;
        this.Ii = n3 / 8000.0;
    }
    
    public VelocitySnapshot(final Vector vector) {
        this.II = vector.getX();
        this.iI = vector.getY();
        this.Ii = vector.getZ();
    }
    
    @Override
    public String toString() {
        return "Velocity{x=" + this.II + ", y=" + this.iI + ", z=" + this.Ii + '}';
    }
    
    public double getX() {
        return this.II;
    }
    
    public double getY() {
        return this.iI;
    }
    
    public double getZ() {
        return this.Ii;
    }
    
    public Vector II() {
        return new Vector(this.II, this.iI, this.Ii);
    }
    
    public double ii() {
        return MathUtil.Ii(this.II, this.Ii);
    }
    
    public double ll() {
        return MathUtil.hypot(this.II, this.iI, this.Ii);
    }
    
    public double lI() {
        return Math.abs(this.iI);
    }
}
