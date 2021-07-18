package kizuki.ac.check.impl.scaffold;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.util.*;
import kizuki.ac.utils.*;

public class ScaffoldB extends KizukiCheck
{
    CPacketBlockPlace verbosePattern;
    int verbosePattern;
    boolean iI;
    
    public ScaffoldB(final PlayerData playerData) {
        super(playerData, CheckType.SCAFFOLD, "Scaffold (B)", "ScaffoldB", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = null;
        this.verbosePattern = 0;
        this.iI = false;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            this.debug("swing");
            this.iI = true;
        }
        else if (packet instanceof CPacketBlockPlace) {
            if (!this.getPlayerData().getPlayer().getItemInHand().getType().isSolid()) {
                return;
            }
            this.debug("blockplace");
            this.verbosePattern = (CPacketBlockPlace)packet;
        }
        else if (packet instanceof CPacketFlying) {
            if (this.verbosePattern != null && this.iI) {
                final Vector vector = this.getPlayerData().getPlayer().getEyeLocation().toVector();
                if (this.verbosePattern.getBlockPosition() == null) {
                    return;
                }
                final Vector vector2 = new Vector(this.verbosePattern.getBlockPosition().getX(), this.verbosePattern.getBlockPosition().getY(), this.verbosePattern.getBlockPosition().getZ());
                if (!this.getPlayerData().hasGivenVelocity(vector2)) {
                    final float angle = vector2.clone().subtract(vector).angle(this.getPlayerData().getPlayer().getEyeLocation().getDirection());
                    final float n = (float)vector.distance(vector2);
                    final boolean b = (vector2.getX() == -1.0 && vector2.getY() == -1.0 && vector2.getZ() == -1.0) || this.getPlayerData().getPlayer().isFlying();
                    final boolean b2 = ((CPacketFlying)packet).getDeltaYaw() < 10.0f && ((CPacketFlying)packet).getDeltaPitch() < 15.0f && n > 1.5 && angle > 1.0;
                    this.debug(BlockUtils.isInAir(this.getPlayerData().getPlayer()).equals(BlockUtils.getBlock(this.getPlayerData().getPlayer().getWorld(), vector2)) + "");
                    if (b2 && !b) {
                        if (this.verbosePattern++ > 3) {
                            this.flag("@author Tecnio. miss -> " + BlockUtils.isInAir(this.getPlayerData().getPlayer()).equals(BlockUtils.getBlock(this.getPlayerData().getPlayer().getWorld(), vector2)));
                        }
                    }
                    else {
                        this.verbosePattern = Math.max(0, this.verbosePattern - 2);
                    }
                }
            }
            this.verbosePattern = null;
            this.iI = false;
        }
    }
}
