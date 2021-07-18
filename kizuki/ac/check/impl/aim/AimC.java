package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import java.util.function.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class AimC extends KizukiCheck
{
    private final Predicate predicate;
    float lastAbsDeltaPitch;
    float lastDeltaYaw;
    float buffer;
    
    public AimC(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (C)", "AimC", DevelopmentState.EXPERIMENTAL, true);
        this.predicate = (n -> n == Math.round(n) && n > 0.0);
        this.lastAbsDeltaPitch = -69.0f;
        this.lastDeltaYaw = -69.0f;
        this.buffer = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            if (this.getPlayerData().II(3)) {
                return;
            }
            if (cPacketFlying.isLook()) {
                final float deltaYaw = cPacketFlying.getDeltaYaw();
                final float abs = Math.abs(cPacketFlying.getDeltaPitch());
                final float abs2 = Math.abs(this.lastAbsDeltaPitch - abs);
                final float abs3 = Math.abs(this.lastDeltaYaw - deltaYaw);
                final float n = deltaYaw % 360.0f;
                final boolean b = Math.abs(((CPacketFlying)packet).getTo().getPitch()) < 80.0f;
                if (this.predicate.test(abs3) || (this.predicate.test(abs2) && b) || this.predicate.test(n) || (this.predicate.test(abs) && b)) {
                    final float buffer = this.buffer + 1.0f;
                    this.buffer = buffer;
                    if (buffer > 5.0f) {
                        this.flag("a -> " + abs3 + ", b -> " + abs2 + ", c -> " + n + ", d -> " + abs);
                    }
                }
                else {
                    this.buffer = Math.max(0.0f, this.buffer - 0.25f);
                }
                this.lastDeltaYaw = deltaYaw;
                this.lastAbsDeltaPitch = abs;
            }
        }
    }
}
