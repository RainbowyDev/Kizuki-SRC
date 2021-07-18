package kizuki.ac;

import org.jetbrains.annotations.*;

public class qj implements qk
{
    private final String II;
    
    public qj(final String ii) {
        this.II = ii;
    }
    
    @NotNull
    @Override
    public Object II() {
        throw new RuntimeException(this.II());
    }
    
    @Override
    public boolean II() {
        return true;
    }
    
    @Nullable
    @Override
    public String II() {
        return this.II;
    }
}
