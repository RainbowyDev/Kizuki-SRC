package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class AimA extends KizukiCheck
{
    float lastDeltaPitch;
    float lastDeltaYaw;
    float lastRawDeltaPitch;
    float lastDeltaYawOriented;
    float lastAccelYaw;
    float lastAccelPitch;
    float yawBuffer;
    float pitchBuffer;
    float accelYawBuffer;
    float accelPitchBuffer;
    
    public AimA(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (A)", "AimA", DevelopmentState.EXPERIMENTAL, true);
        this.lastDeltaPitch = -69.0f;
        this.lastDeltaYaw = -69.0f;
        this.lastRawDeltaPitch = -69.0f;
        this.lastDeltaYawOriented = -69.0f;
        this.lastAccelYaw = 0.0f;
        this.lastAccelPitch = 0.0f;
        this.yawBuffer = 0.0f;
        this.pitchBuffer = 0.0f;
        this.accelYawBuffer = 0.0f;
        this.accelPitchBuffer = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            if (cPacketFlying.isLook() && !this.getPlayerData().iI()) {
                final boolean b = this.getPlayerData().qp > 65 && this.getPlayerData().qp < 145;
                final float deltaYaw = cPacketFlying.getDeltaYaw();
                final float abs = Math.abs(cPacketFlying.getDeltaPitch());
                final float lastDeltaYawOriented = cPacketFlying.getDeltaYaw() * (cPacketFlying.isInverse() ? 1 : -1);
                final float deltaPitch = cPacketFlying.getDeltaPitch();
                final float abs2 = Math.abs(this.lastDeltaYaw - deltaYaw);
                final float abs3 = Math.abs(this.lastDeltaPitch - abs);
                if (b) {
                    if (deltaYaw == this.lastDeltaYaw || abs2 == this.lastAccelYaw) {
                        if (deltaYaw > 1.0f && deltaYaw < 30.0f) {
                            ++this.yawBuffer;
                        }
                    }
                    else {
                        this.yawBuffer = Math.max(0.0f, this.yawBuffer - 1.5f);
                    }
                    if (abs == this.lastDeltaPitch || abs3 == this.lastAccelPitch) {
                        if (abs > 1.0f && abs < 20.0f) {
                            ++this.pitchBuffer;
                        }
                    }
                    else {
                        this.pitchBuffer = Math.max(0.0f, this.pitchBuffer - 1.5f);
                    }
                    if (this.yawBuffer == this.pitchBuffer && this.yawBuffer > 4.0f) {
                        this.flag("a/a a -> " + this.yawBuffer);
                    }
                    if (abs == this.lastDeltaPitch || abs3 == this.lastAccelPitch) {
                        if (abs > 1.0f && abs < 30.0f) {
                            ++this.accelPitchBuffer;
                        }
                    }
                    else {
                        this.accelPitchBuffer = Math.max(0.0f, this.accelPitchBuffer - 1.5f);
                    }
                    if (deltaYaw == this.lastDeltaYaw || abs2 == this.lastAccelYaw) {
                        if (deltaYaw > 1.0f && deltaYaw < 30.0f) {
                            ++this.accelYawBuffer;
                        }
                    }
                    else {
                        this.accelYawBuffer = Math.max(0.0f, this.accelYawBuffer - 1.5f);
                    }
                    if (this.yawBuffer > 5.0f) {
                        this.flag("a/b a -> " + deltaYaw + ", b -> " + abs2);
                    }
                    if (this.accelYawBuffer > 5.0f) {
                        this.flag("a/c a -> " + deltaYaw + ", b -> " + abs2);
                    }
                    if (this.pitchBuffer > 5.0f) {
                        this.flag("a/d a -> " + abs + ", b -> " + abs3);
                    }
                    if (this.accelPitchBuffer > 5.0f) {
                        this.flag("a/e a -> " + abs + ", b -> " + abs3);
                    }
                }
                this.lastAccelYaw = abs2;
                this.lastAccelPitch = abs3;
                this.lastDeltaYaw = deltaYaw;
                this.lastDeltaPitch = abs;
                this.lastDeltaYawOriented = lastDeltaYawOriented;
                this.lastRawDeltaPitch = deltaPitch;
            }
        }
    }
}
