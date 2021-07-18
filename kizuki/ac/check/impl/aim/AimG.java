package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;

public class AimG extends KizukiCheck
{
    float jittredBuffer;
    float iI;
    float Ii;
    float deltaYaw;
    float buffer;
    float lI;
    int verbosePattern;
    float deltaPitch;
    float LL;
    float streaks;
    private float qw;
    
    public AimG(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (G)", "AimG", DevelopmentState.FINAL, true);
        this.jittredBuffer = 0.0f;
        this.iI = 0.0f;
        this.Ii = 0.0f;
        this.deltaYaw = 0.0f;
        this.buffer = 0.0f;
        this.lI = 0.0f;
        this.verbosePattern = 0;
        this.deltaPitch = -69.0f;
        this.LL = -69.0f;
        this.streaks = 0.0f;
    }
    
    public static double roundToDecimal(final double n, final int n2) {
        return Math.round(n * Math.pow(10.0, n2)) / Math.pow(10.0, n2);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final float deltaYaw = cPacketFlying.getDeltaYaw();
            final float abs = Math.abs(cPacketFlying.getDeltaPitch());
            final float abs2 = Math.abs(this.deltaYaw - deltaYaw);
            final float abs3 = Math.abs(this.jittredBuffer - abs);
            final float ll = deltaYaw * (cPacketFlying.isInverse() ? 1 : -1);
            final float deltaPitch = cPacketFlying.getDeltaPitch();
            final boolean boolSetting = this.getBoolSetting("aa");
            final int intSetting = this.getIntSetting("aarate");
            final boolean boolSetting2 = this.getBoolSetting("ba");
            final int intSetting2 = this.getIntSetting("barate");
            final int intSetting3 = this.getIntSetting("badecrease");
            final boolean boolSetting3 = this.getBoolSetting("ca");
            final int intSetting4 = this.getIntSetting("carate");
            final boolean b = this.getPlayerData().qp > 65 && this.getPlayerData().qp < 145 && this.getPlayerData().iI > 0.007 && this.getPlayerData().iI < 0.7;
            final boolean b2 = (abs2 < 0.1 && deltaYaw > 2.0f) || (abs3 < 0.1 && abs > 2.0f);
            final boolean b3 = (this.deltaPitch < 0.0f && deltaPitch > 0.0f) || (this.deltaPitch > 0.0f && deltaPitch < 0.0f) || (this.LL < 0.0f && ll > 0.0f) || (this.LL > 0.0f && ll < 0.0f);
            final boolean b4 = deltaYaw > 3.0f && abs > 3.0f && deltaYaw < 14.0f && abs < 20.0f;
            if (b3 && b4 && b && boolSetting && this.getPlayerData().hitTicks < 6) {
                this.debug("jittred " + this.verbosePattern);
                if (this.verbosePattern++ > intSetting) {
                    this.flag("a/a a -> " + deltaYaw + ", b -> " + abs + ", c -> " + this.verbosePattern);
                }
            }
            else {
                this.verbosePattern = Math.max(0, this.verbosePattern - 2);
            }
            if (b2 && b4 && b && boolSetting2) {
                final float buffer = this.buffer;
                this.buffer = buffer + 1.0f;
                if (buffer > intSetting2) {
                    this.flag("b/a a -> " + this.buffer + ", b -> " + abs2 + ", c -> " + abs3, this.buffer - 10.0f);
                }
            }
            else {
                this.buffer = Math.max(0.0f, this.buffer - intSetting3);
            }
            final double roundToDecimal = roundToDecimal(Math.abs(abs2 / (this.iI * 0.5)), 3);
            if (roundToDecimal % 0.1 == 0.0 && roundToDecimal < 100.0 && deltaYaw > 2.0f && boolSetting3) {
                final float streaks = this.streaks;
                this.streaks = streaks + 1.0f;
                if (streaks > intSetting4) {
                    if (this.streaks > 15.0f) {
                        this.streaks = 15.0f;
                    }
                    this.flag("c/a a -> " + roundToDecimal + ", b -> " + this.streaks);
                }
            }
            else {
                this.streaks -= (float)0.2;
                if (this.streaks < 0.0f) {
                    this.streaks = 0.0f;
                }
            }
            this.qw = (float)MathUtil.II(abs3, (double)this.Ii);
            this.deltaYaw = deltaYaw;
            this.jittredBuffer = abs;
            this.LL = ll;
            this.deltaPitch = deltaPitch;
            this.iI = abs2;
            this.Ii = abs3;
        }
    }
}
