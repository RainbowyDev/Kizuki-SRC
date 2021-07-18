package kizuki.ac.check.impl.scaffold;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;
import org.bukkit.block.*;

public class ScaffoldD extends KizukiCheck
{
    CPacketFlying verbosePattern;
    int verbosePattern;
    
    public ScaffoldD(final PlayerData playerData) {
        super(playerData, CheckType.SCAFFOLD, "Scaffold (D)", "ScaffoldD", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = null;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketEntityAction) {
            if (this.verbosePattern != null && this.verbosePattern.getDeltaXZ() > 0.13 && this.verbosePattern.isGround()) {
                final Block block = BlockUtils.getBlock(this.verbosePattern.getTo().toLocation().clone().add(0.0, -0.2, 0.0));
                if (block != null) {
                    if (!block.getType().isSolid() && this.getPlayerData().sneaking) {
                        if (this.verbosePattern++ > config.II(this.Ii() + ".times")) {
                            this.flag("a -> " + this.verbosePattern.getDeltaXZ());
                        }
                    }
                    else {
                        this.verbosePattern = 0;
                    }
                }
            }
            this.verbosePattern = null;
        }
        else if (packet instanceof CPacketFlying) {
            this.verbosePattern = (CPacketFlying)packet;
        }
    }
}
