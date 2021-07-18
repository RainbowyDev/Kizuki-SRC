package kizuki.ac.check.impl.analysis;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class AnalysisA extends KizukiCheck
{
    float verbosePattern;
    float iI;
    float Ii;
    float ii;
    float ll;
    
    public AnalysisA(final PlayerData playerData) {
        super(playerData, CheckType.ANALYSIS, "Analysis (A)", "AnalysisA", DevelopmentState.FINAL, true);
        this.verbosePattern = 0.0f;
        this.iI = 0.0f;
        this.Ii = 0.0f;
        this.ii = 0.0f;
        this.ll = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final float deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
            final float deltaPitch = ((CPacketFlying)packet).getDeltaPitch();
            final float abs = Math.abs(this.verbosePattern - deltaYaw);
            final float abs2 = Math.abs(this.iI - deltaPitch);
            final float abs3 = Math.abs(this.Ii - abs);
            final float abs4 = Math.abs(this.ii - abs2);
            final boolean b = this.getPlayerData().qp > 65 && this.getPlayerData().qp < 145;
            final boolean b2 = deltaYaw > 2.0f && (abs < 0.075 || abs3 < 0.1) && deltaYaw < 12.0f;
            final boolean b3 = deltaPitch > 2.0f && (abs2 < 0.075 || abs4 < 0.1) && deltaPitch < 12.0f;
            if (b && (b2 || b3)) {
                final float ll = this.ll;
                this.ll = ll + 1.0f;
                if (ll > 4.0f) {
                    this.flag("a -> " + abs + ", b -> " + abs2);
                }
            }
            else {
                this.ll = Math.max(0.0f, this.ll - 0.5f);
            }
            this.Ii = abs;
            this.ii = abs2;
            this.verbosePattern = deltaYaw;
            this.iI = deltaPitch;
        }
    }
}
