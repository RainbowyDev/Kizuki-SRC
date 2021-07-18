package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;

public class AimF extends KizukiCheck
{
    static double factor;
    EvictingList samples;
    float verbosePattern;
    float lastDeltaPitch;
    float buffer;
    private double lastGcd;
    
    public AimF(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (F)", "AimF", DevelopmentState.FINAL, true);
        this.samples = new EvictingList(20, true);
        this.verbosePattern = 0.0f;
        this.lastDeltaPitch = 0.0f;
        this.buffer = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final float deltaPitch = ((CPacketFlying)packet).getDeltaPitch();
            final float deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
            if (deltaPitch > 0.3 && ((CPacketFlying)packet).getDeltaYaw() > 0.5 && deltaPitch < 8.0f) {
                final double lastGcd = (double)MathUtil.II(16384L, (long)(deltaPitch * AimF.factor), (long)(this.verbosePattern * AimF.factor));
                this.samples.add(lastGcd < 131072.0 && Math.abs(this.lastDeltaPitch - deltaYaw) > 0.1 && Math.abs(this.verbosePattern - deltaPitch) > 0.3);
                final boolean b2 = lastGcd < 131072.0 && (this.getPlayerData().iI < 0.0075 || this.getPlayerData().iI > 1.0f);
                final boolean b3 = Math.abs(this.lastDeltaPitch - deltaYaw) < 0.12 || Math.abs(this.verbosePattern - deltaPitch) < 0.12 || deltaPitch > deltaYaw;
                this.debug(Math.abs(this.lastGcd / AimF.factor - lastGcd / AimF.factor) + " " + this.getPlayerData().iI + " " + b3 + " " + this.buffer);
                if (b2) {
                    if (!b3) {
                        final float buffer = this.buffer;
                        this.buffer = buffer + 1.0f;
                        if (buffer > 3.0f) {
                            this.flag("basic -> " + lastGcd + ", calc -> " + this.getPlayerData().iI + ", failed -> " + deltaPitch % this.getPlayerData().Ii + ", clickaimbot -> " + this.samples.stream().filter(b -> b).count());
                        }
                    }
                    else {
                        this.buffer = Math.max(this.buffer - 0.1f, 0.0f);
                    }
                }
                else {
                    this.buffer = Math.max(this.buffer - 0.2f, 0.0f);
                }
                this.lastGcd = lastGcd;
            }
            this.lastDeltaPitch = deltaYaw;
            this.verbosePattern = deltaPitch;
        }
    }
    
    static {
        AimF.factor = Math.pow(2.0, 24.0);
    }
}
