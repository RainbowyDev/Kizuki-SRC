package kizuki.ac;

import kizuki.ac.packet.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class uf extends Packet
{
    Player iI;
    
    public uf(final Player ii) {
        super(ii);
        this.iI = ii;
    }
    
    @NotNull
    @Override
    public Player getPlayer() {
        return this.iI;
    }
}
