package kizuki.ac.utils;

import org.bukkit.util.*;
import org.bukkit.*;

public class Ray
{
    private final Vector origin;
    private final Vector direction;
    
    public Ray(final Vector origin, final Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }
    
    public Ray(final Location location) {
        this.origin = location.toVector();
        this.direction = location.getDirection();
    }
    
    @Override
    public String toString() {
        return "Ray{origin=" + this.origin.toString() + ", direction=" + this.direction.toString() + '}';
    }
    
    public Vector getOrigin() {
        return this.origin;
    }
    
    public Vector getDirection() {
        return this.direction;
    }
    
    public Vector II(final double n) {
        return new Vector(this.origin.getX(), this.origin.getY(), this.origin.getZ()).add(new Vector(this.direction.getX(), this.direction.getY(), this.direction.getZ()).multiply(n));
    }
}
