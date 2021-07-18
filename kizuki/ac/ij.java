package kizuki.ac;

public class ij
{
    long II;
    long iI;
    long Ii;
    int II;
    
    public ij() {
        this.II = 0L;
        this.iI = 0L;
        this.Ii = 0L;
        this.II = 0;
    }
    
    public int II() {
        final long ii = (System.nanoTime() - this.iI - 50000000L) / 1000000L;
        if (ii > this.II) {
            this.II = ii;
            if (ii > 75L) {
                this.Ii = System.currentTimeMillis();
            }
        }
        return (int)this.II;
    }
    
    public void II() {
        long ii = (System.nanoTime() - this.iI - 50000000L) / 1000000L;
        if (ii < 0L) {
            ii = 0L;
        }
        if (this.iI == 0L) {
            ii = 0L;
        }
        if (ii > 75L && ii >= this.II) {
            this.Ii = System.currentTimeMillis();
        }
        else {
            this.II = 0;
        }
        if (ii > this.II) {
            this.II = ii;
            if (ii > 75L) {
                this.Ii = System.currentTimeMillis();
            }
        }
        else if (System.currentTimeMillis() - this.Ii > 1000L) {
            this.II = (this.II * 5L + ii) / 6L;
        }
        this.iI = System.nanoTime();
    }
}
