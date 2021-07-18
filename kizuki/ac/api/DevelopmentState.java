package kizuki.ac.api;

public enum DevelopmentState
{
    DEVELOPMENT("DEVELOPMENT", 0), 
    EXPERIMENTAL("EXPERIMENTAL", 1), 
    TESTED("TESTED", 2), 
    FINAL("FINAL", 3);
    
    private DevelopmentState(final String s, final int n) {
    }
}
