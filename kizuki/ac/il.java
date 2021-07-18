package kizuki.ac;

class il implements Runnable
{
    long II;
    long iI;
    int II;
    final /* synthetic */ ik II;
    
    il(final ik ii) {
        this.II = ii;
    }
    
    @Override
    public void run() {
        this.II = System.currentTimeMillis() / 1000L;
        if (this.II == this.iI) {
            ++this.II;
        }
        else {
            this.iI = this.II;
            this.II.II = ((this.II.II == 0.0) ? this.II : ((this.II.II + this.II) / 2.0));
            this.II = 1;
        }
    }
}
