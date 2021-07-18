package kizuki.ac.api;

import kizuki.ac.check.*;
import org.bukkit.entity.*;

public class KizukiACCheckAPI
{
    final KizukiCheck check;
    
    public KizukiACCheckAPI(final KizukiCheck check) {
        this.check = check;
    }
    
    public Player getPlayer() {
        return this.check.getPlayerData().getPlayer();
    }
    
    public LimitedDouble getVL() {
        return this.check.II();
    }
    
    public String getChatName() {
        return this.check.II();
    }
    
    public String getConfigLocation() {
        return this.check.Ii();
    }
    
    public CheckType getCheckType() {
        return this.check.getCheckType();
    }
}
