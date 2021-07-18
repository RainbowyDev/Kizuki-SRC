package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;

public class AimD extends KizukiCheck
{
    int buffer;
    
    public AimD(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (D)", "AimD", DevelopmentState.FINAL, true);
        this.buffer = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final float deltaPitch = cPacketFlying.getDeltaPitch();
            final float deltaYaw = cPacketFlying.getDeltaYaw();
            final float pitch = cPacketFlying.getTo().getPitch();
            final boolean b = (MathUtil.isEulerSmall(deltaPitch) || deltaPitch == 0.0f) && deltaYaw > 6.0f && Math.abs(pitch) < 85.0f && deltaYaw < 30.0f;
            final boolean b2 = (MathUtil.isEulerSmall(deltaYaw) || deltaYaw == 0.0f) && deltaPitch > 6.0f && deltaPitch < 30.0f;
            if (b || b2) {
                if (this.buffer++ > 15) {
                    this.flag("a -> " + deltaYaw + ", b -> " + deltaPitch, (float)(this.buffer - 20));
                }
            }
            else {
                this.buffer = 0;
            }
        }
    }
}
