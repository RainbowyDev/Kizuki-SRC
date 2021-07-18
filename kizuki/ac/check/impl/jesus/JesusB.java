package kizuki.ac.check.impl.jesus;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class JesusB extends KizukiCheck
{
    float verbosePattern;
    private double verbosePattern;
    
    public JesusB(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Jesus (B)", "JesusB", DevelopmentState.FINAL, false);
        this.verbosePattern = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying && this.getPlayerData().sinceLiquidTicks == 0 && !((CPacketFlying)packet).getTo().ll() && this.getPlayerData().sneaking > 3 && this.getPlayerData().sinceBoundingBoxEmpty > 2) {
            final double deltaY = ((CPacketFlying)packet).getDeltaY();
            this.verbosePattern = 0.0f;
            this.verbosePattern = deltaY;
        }
    }
}
