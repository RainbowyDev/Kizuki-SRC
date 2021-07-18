package kizuki.ac;

public class uk
{
    private Object II;
    private Object iI;
    
    public uk(final Object ii, final Object ii2) {
        this.II = ii;
        this.iI = ii2;
    }
    
    public uk(final uk uk) {
        this.II = uk.II;
        this.iI = uk.iI;
    }
    
    public Object II() {
        return this.II;
    }
    
    public void II(final Object ii) {
        this.II = ii;
    }
    
    public Object iI() {
        return this.iI;
    }
    
    public void iI(final Object ii) {
        this.iI = ii;
    }
    
    @Override
    public String toString() {
        return "Pair{key=" + this.II + ", value=" + this.iI + '}';
    }
}
