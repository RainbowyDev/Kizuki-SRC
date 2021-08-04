package kizuki.ac.check.impl.timer;

import kizuki.ac.check.*;
import java.util.function.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import java.util.*;
import kizuki.ac.packet.wrapper.*;

public class TimerA extends KizukiCheck
{
    private final Predicate verbosePattern;
    private final EvictingList verbosePattern;
    double verbosePattern;
    float verbosePattern;
    
    public TimerA(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Timer (A)", "TimerA", DevelopmentState.FINAL, false);
        this.verbosePattern = (n -> n < 715.0);
        this.verbosePattern = new EvictingList(50);
        this.verbosePattern = 0.0;
        this.verbosePattern = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            this.verbosePattern.add(this.getTime());
            if (!this.verbosePattern.isFull()) {
                return;
            }
            final double variance = MathUtil.getVariance(this.verbosePattern);
            final double verbosePattern = this.verbosePattern;
            this.verbosePattern = variance;
            final double abs = Math.abs(variance - verbosePattern);
            final boolean b = this.getPlayerData().Il() || this.getPlayerData().getPlayer().isInsideVehicle();
            if ((this.verbosePattern.test(variance) && abs <= 50.0 && !b) || (variance < 400.0 && this.getPlayerData().II(3) && (((CPacketFlying)packet).getDeltaXZ() > 0.001 || Math.abs(((CPacketFlying)packet).getDeltaY()) > 0.001 || this.getPlayerData().getPlayer().getHealth() != this.getPlayerData().getPlayer().getMaxHealth()))) {
                final float verbosePattern2 = this.verbosePattern;
                this.verbosePattern = verbosePattern2 + 1.0f;
                if (verbosePattern2 >= config.II(this.Ii() + ".threshold")) {
                    this.flag("dev -> " + variance);
                }
            }
            else {
                this.verbosePattern = Math.max(0.0f, this.verbosePattern - 0.25f);
            }
        }
        else if (packet instanceof CPacketPotatoGood) {
            this.verbosePattern.add(this.getTime() * 2L);
        }
    }
}
