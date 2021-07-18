package kizuki.ac.check.enums;

public enum CheckType
{
    II("AIM", 0, "BOW", "AIM", "This type of checks is targeted to detect aimbot-like aiming"), 
    iI("KILLAURA", 1, "IRON_SWORD", "KILLAURA", "This type of checks is targeted to detect basic things in killauras"), 
    Ii("HAND", 2, "DIAMOND_HOE", "HAND", "This type of checks is targeted to detect illegal player interactions"), 
    ii("SCAFFOLD", 3, "GRASS", "WORLD", "This type of checks is targeted to detect scaffold-walk hack"), 
    ll("HITBOX", 4, "BARRIER", "HITBOX", "This type of checks is targeted to detect illegal reach of hitbox expanding hacks"), 
    lI("AUTOCLICKER", 5, "REDSTONE", "AUTOCLICKER", "This type of checks is targeted to detect autoclicker modules"), 
    Il("MOVEMENT", 6, "FEATHER", "MOVE", "This type of checks is targeted to detect illegal/impossible player moves"), 
    LL("ANALYSIS", 7, "DIAMOND", "ANALYSIS", "This type of checks is targeted to detect aimassists but works slower than basic aim checl"), 
    qq("VELOCITY", 8, "BLAZE_ROD", "VELOCITY", "This type of checks is targeted to detect illegal velocity changes"), 
    qw("PACKET", 9, "GOLDEN_APPLE", "PACKET", "This type of checks is targeted to detect impossible for vanilla player packet things");
    
    private final String II;
    private final String iI;
    private final String Ii;
    
    private CheckType(final String s, final int n, final String ii, final String ii2, final String ii3) {
        this.II = ii;
        this.iI = ii2;
        this.Ii = ii3;
    }
    
    public String II() {
        return this.Ii;
    }
    
    public String iI() {
        return this.II;
    }
    
    public String Ii() {
        return this.iI;
    }
}
