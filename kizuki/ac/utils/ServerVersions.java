package kizuki.ac.utils;

public enum ServerVersions
{
    II("v1_8_R1", 0, 47), 
    iI("v1_8_R3", 1, 47), 
    Ii("v1_12_R1", 2, 340);
    
    int II;
    
    private ServerVersions(final String s, final int n, final int ii) {
        this.II = ii;
    }
    
    public int II() {
        return this.II;
    }
}
