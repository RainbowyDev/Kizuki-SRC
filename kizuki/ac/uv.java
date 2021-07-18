package kizuki.ac;

import org.bukkit.util.*;

public class uv
{
    public double II;
    public double iI;
    public double Ii;
    public double ii;
    public double ll;
    public double lI;
    public double Il;
    public double LL;
    public double qq;
    public Vector II;
    
    public uv(final double ii, final double ii2, final double ii3, final double ii4, final double ll, final double li) {
        this.II = ii;
        this.iI = ii2;
        this.Ii = ii3;
        this.ii = ii4;
        this.ll = ll;
        this.lI = li;
        this.Il = Math.abs(ii - ii4);
        this.LL = Math.abs(ii2 - ll);
        this.qq = Math.abs(ii3 - li);
        this.II = new Vector((ii + ii4) / 2.0, (ii2 + ll) / 2.0, (ii3 + li) / 2.0);
    }
    
    public uv II(final double n, final double n2, final double n3) {
        return new uv(this.II - n, this.iI - n2, this.Ii - n3, this.ii + n, this.ll + n2, this.lI + n3);
    }
}
