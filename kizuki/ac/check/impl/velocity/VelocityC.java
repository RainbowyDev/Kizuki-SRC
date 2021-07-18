package kizuki.ac.check.impl.velocity;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class VelocityC extends KizukiCheck
{
    long verbosePattern;
    double verbosePattern;
    double iI;
    double Ii;
    
    public VelocityC(final PlayerData playerData) {
        super(playerData, CheckType.VELOCITY, "Velocity (C)", "VelocityC", DevelopmentState.DEVELOPMENT, false);
        this.verbosePattern = 0L;
        this.verbosePattern = 0.0;
        this.iI = 0.0;
        this.Ii = 0.0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final double ii = cPacketFlying.getTo().getX() - cPacketFlying.getFrom().getX();
            final double ii2 = cPacketFlying.getTo().getZ() - cPacketFlying.getFrom().getZ();
            final double deltaXZ = cPacketFlying.getDeltaXZ();
            if (Math.abs(deltaXZ - this.verbosePattern) > deltaXZ / 20.0 && this.getPlayerData().sneaking > 2 && !cPacketFlying.getTo().isFull()) {
                this.debug(" " + Math.abs(deltaXZ - this.verbosePattern));
            }
            this.verbosePattern = deltaXZ;
            this.iI = ii;
            this.Ii = ii2;
        }
    }
}
