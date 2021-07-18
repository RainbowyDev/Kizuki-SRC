package kizuki.ac.api;

public enum CheckType
{
    AIM("AIM", 0, "AimAssist", "AIM"), 
    KILLAURA("KILLAURA", 1, "KillAura", "KILLAURA"), 
    HAND("HAND", 2, "Hand", "HAND"), 
    SCAFFOLD("SCAFFOLD", 3, "Scaffold", "WORLD"), 
    HITBOX("HITBOX", 4, "HitBox", "HITBOX"), 
    AUTOCLICKER("AUTOCLICKER", 5, "AutoClicker", "AUTOCLICKER"), 
    MOVEMENT("MOVEMENT", 6, "Move", "MOVE"), 
    ANALYSIS("ANALYSIS", 7, "Analysis", "ANALYSIS"), 
    VELOCITY("VELOCITY", 8, "Velocity", "VELOCITY"), 
    PACKET("PACKET", 9, "Packet", "PACKET");
    
    private final String checkName;
    private final String configLocation;
    
    private CheckType(final String s, final int n, final String checkName, final String configLocation) {
        this.checkName = checkName;
        this.configLocation = configLocation;
    }
    
    public String getCheckName() {
        return this.checkName;
    }
    
    public String getConfigLocation() {
        return this.configLocation;
    }
}
