package kizuki.ac.check.impl.timer;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class TimerB extends KizukiCheck
{
    public double verbosePattern;
    double iI;
    int verbosePattern;
    
    public TimerB(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Timer (B)", "TimerB", DevelopmentState.FINAL, false);
        this.verbosePattern = 0.0;
        this.iI = 0.0;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final double ii = (double)this.getTime();
            if (this.iI != 0.0 && this.verbosePattern++ > 50) {
                if (this.getPlayerData().II(5)) {
                    this.verbosePattern -= 150.0;
                }
                this.verbosePattern += 50.0 + this.iI - ii;
                if (this.verbosePattern < -500.0) {
                    this.verbosePattern = -500.0;
                }
                if (this.verbosePattern < 0.0) {
                    this.verbosePattern += 2.0;
                }
                else if (this.verbosePattern > 0.0) {
                    this.verbosePattern -= 0.05;
                }
                final boolean b = System.currentTimeMillis() - this.getPlayerData().iI < 250.0;
                if (this.verbosePattern >= 350.0 && !b && (((CPacketFlying)packet).getDeltaXZ() > 0.001 || Math.abs(((CPacketFlying)packet).getDeltaY()) > 0.001 || this.getPlayerData().getPlayer().getHealth() != this.getPlayerData().getPlayer().getMaxHealth())) {
                    this.flag("ms -> " + (this.verbosePattern - 250.0));
                    this.verbosePattern = 200.0;
                }
            }
            this.iI = ii;
        }
        else if (packet instanceof CPacketMoveCustom) {
            this.verbosePattern -= 150.0;
        }
    }
}
