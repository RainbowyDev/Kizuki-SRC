package kizuki.ac;

public enum qx
{
    II("Normal", 0, 0), 
    iI("Pro", 1, 1);
    
    private final int II;
    
    private qx(final String s, final int n, final int ii) {
        this.II = ii;
    }
    
    public static qx II(final int n) {
        switch (n) {
            case 0: {
                return qx.II;
            }
            case 1: {
                return qx.iI;
            }
            default: {
                throw new UnsupportedOperationException("Account type with value " + n + " is not supported yet");
            }
        }
    }
    
    public int II() {
        return this.II;
    }
}
