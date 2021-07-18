package kizuki.ac.utils.block;

import org.bukkit.*;
import org.bukkit.util.*;

public class KizukiBlock
{
    final Material material;
    final Vector vector;
    
    public KizukiBlock(final Material material, final int n, final int n2, final int n3) {
        this.material = material;
        this.vector = new Vector(n, n2, n3);
    }
    
    public Material getMaterial() {
        return this.material;
    }
    
    public Vector getVector() {
        return this.vector;
    }
    
    public boolean II(final Vector vector) {
        return Math.sqrt(Math.pow(this.vector.getX() - vector.getX(), 2.0) + Math.pow(this.vector.getY() - vector.getY(), 2.0) + Math.pow(this.vector.getZ() - vector.getZ(), 2.0)) < 5.0 && vector.getY() + 1.0 > this.vector.getY();
    }
    
    public boolean isEquals(final Vector vector) {
        return vector.getX() == this.vector.getX() && vector.getY() == this.vector.getY() && vector.getZ() == this.vector.getZ();
    }
}
