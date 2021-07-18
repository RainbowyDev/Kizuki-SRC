package kizuki.ac.check.impl.velocity;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class VelocityB extends KizukiCheck
{
    long verbosePattern;
    double verbosePattern;
    double iI;
    double Ii;
    
    public VelocityB(final PlayerData playerData) {
        super(playerData, CheckType.VELOCITY, "Velocity (B)", "VelocityB", DevelopmentState.FINAL, false);
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
            if (this.getPlayerData().sneaking > 0 && ((deltaXZ > 0.23 && this.verbosePattern > 0.23) || (this.verbosePattern > 0.25 && deltaXZ < 0.005)) && !this.getPlayerData().II(cPacketFlying) && !cPacketFlying.getTo().isFull() && this.getPlayerData().iI(5) && !this.getPlayerData().iI()) {
                if (this.verbosePattern > 0.25 && deltaXZ < 0.05) {
                    this.debug("failed");
                }
                if (this.getPlayerData().II.ii() >= 0.1) {
                    if (((this.iI < -0.065 && ii > 0.065) || (this.iI > 0.065 && ii < -0.065) || (this.Ii < -0.065 && ii2 > 0.065) || (this.Ii > 0.065 && ii2 < -0.065) || (Math.abs(this.iI) > 0.13 && Math.abs(this.iI) < 0.05) || (Math.abs(this.Ii) > 0.13 && Math.abs(this.Ii) < 0.05) || (this.verbosePattern > 0.25 && deltaXZ < 0.005)) && !this.getPlayerData().iI() && this.getPlayerData().iI > 3) {
                        if (this.getPlayerData().ll - this.verbosePattern < 40L) {
                            this.flag("x -> " + ii + ", lx -> " + this.iI + ", z -> " + ii2 + ", lz -> " + this.Ii);
                        }
                        this.verbosePattern = this.getPlayerData().ll;
                    }
                }
            }
            if (this.getPlayerData().iI(-5)) {
                this.debug("x -> " + (float)ii + ", lx -> " + (float)this.iI + ", z -> " + (float)ii2 + ", lz -> " + (float)this.Ii);
                this.debug("dxz -> " + (float)deltaXZ + ", ldxz -> " + (float)this.verbosePattern);
            }
            this.verbosePattern = deltaXZ;
            this.iI = ii;
            this.Ii = ii2;
        }
    }
}
