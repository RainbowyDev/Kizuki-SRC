package kizuki.ac;

public enum qg
{
    II("Private", 0, 2), 
    iI("Unlisted", 1, 1), 
    Ii("Public", 2, 0);
    
    private final int II;
    
    private qg(final String s, final int n, final int ii) {
        this.II = ii;
    }
    
    public static qg II(final int n) {
        switch (n) {
            case 0: {
                return qg.Ii;
            }
            case 1: {
                return qg.iI;
            }
            case 2: {
                return qg.II;
            }
            default: {
                throw new UnsupportedOperationException("Unsupported visibility level");
            }
        }
    }
    
    public int II() {
        return this.II;
    }
}
