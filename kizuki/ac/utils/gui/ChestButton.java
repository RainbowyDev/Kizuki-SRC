package kizuki.ac.utils.gui;

import org.bukkit.entity.*;

public abstract class ChestButton
{
    private int II;
    
    public ChestButton(final int ii) {
        this.II = ii;
    }
    
    public void II(final int ii) {
        this.II = ii;
    }
    
    public int II() {
        return this.II;
    }
    
    public abstract void II(final Player p0);
    
    @Override
    public String toString() {
        return "ChestButton{slot=" + this.II + '}';
    }
}
