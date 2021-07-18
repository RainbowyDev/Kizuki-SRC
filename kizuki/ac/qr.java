package kizuki.ac;

import org.jetbrains.annotations.*;

public class qr implements qs
{
    @Nullable
    private final String II;
    @NotNull
    private final String iI;
    private final long II;
    @Nullable
    private final String Ii;
    @Nullable
    private final String ii;
    private final int II;
    @NotNull
    private final qg II;
    @Nullable
    private final qf II;
    private final long iI;
    private final long Ii;
    private String ll;
    
    qr(@Nullable final String ii, @NotNull final String ii2, final long ii3, @Nullable final String ii4, @Nullable final String ii5, final int ii6, @NotNull final qg ii7, @Nullable final qf ii8, final String ll, final long ii9, final long ii10) {
        this.II = ii;
        this.iI = ii2;
        this.II = ii3;
        this.Ii = ii4;
        this.ii = ii5;
        this.II = ii6;
        this.II = ii7;
        this.II = ii8;
        this.ll = ll;
        this.Ii = ii9;
        this.iI = ii10;
    }
    
    @Nullable
    @Override
    public String II() {
        return this.II;
    }
    
    @NotNull
    @Override
    public String iI() {
        return this.iI;
    }
    
    @Override
    public long II() {
        return this.II;
    }
    
    @Nullable
    @Override
    public String Ii() {
        return this.Ii;
    }
    
    @Nullable
    @Override
    public String ii() {
        return this.ii;
    }
    
    @Override
    public int II() {
        return this.II;
    }
    
    @NotNull
    @Override
    public qg II() {
        return this.II;
    }
    
    @Nullable
    @Override
    public qf II() {
        return this.II;
    }
    
    @Override
    public long iI() {
        return this.Ii;
    }
    
    @Override
    public long Ii() {
        return this.iI;
    }
    
    @NotNull
    @Override
    public qk II() {
        if (this.ll != null) {
            return ql.II((Object)this.ll);
        }
        if (this.II == null) {
            return ql.II("This paste doesn't support the raw response");
        }
        final qk ii = qh.II(this.II);
        if (ii.II()) {
            return ii;
        }
        this.ll = (String)ii.II();
        return ql.II((Object)this.ll);
    }
}
