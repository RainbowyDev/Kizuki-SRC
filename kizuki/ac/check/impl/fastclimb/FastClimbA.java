package kizuki.ac.check.impl.fastclimb;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;

public class FastClimbA extends KizukiCheck
{
    public FastClimbA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "FastClimb (A)", "FastClimbA", DevelopmentState.FINAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        final String lowerCase;
        if (packet instanceof CPacketFlying && ((lowerCase = BlockUtils.getCollidedMaterials(((CPacketFlying)packet).getTo(), 0.4, 0.4).toString().toLowerCase()).contains("ladder") || lowerCase.contains("vines")) && !this.getPlayerData().iI(4) && !this.getPlayerData().II() && !((CPacketFlying)packet).getTo().isInLiquid()) {
            if (this.getPlayerData().sneaking > 8) {
                if (((CPacketFlying)packet).getDeltaY() > 0.15) {
                    this.flag("a -> " + this.getPlayerData().sneaking + ", dY -> " + ((CPacketFlying)packet).getDeltaY());
                }
            }
            else if (((CPacketFlying)packet).getDeltaY() > 0.5) {
                this.flag("a -> " + this.getPlayerData().sneaking + ", dY -> " + ((CPacketFlying)packet).getDeltaY());
            }
        }
    }
}
