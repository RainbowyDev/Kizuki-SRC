package kizuki.ac;

import kizuki.ac.check.enums.*;

public class rm
{
    private final CheckType II;
    private final String II;
    
    public rm(final String ii, final CheckType ii2) {
        this.II = ii;
        this.II = ii2;
    }
    
    public String II() {
        return this.II;
    }
    
    public CheckType II() {
        return this.II;
    }
    
    @Override
    public String toString() {
        return "CheckGUI{checkTypeGUI=" + this.II + ", checkName='" + this.II + '\'' + '}';
    }
}
