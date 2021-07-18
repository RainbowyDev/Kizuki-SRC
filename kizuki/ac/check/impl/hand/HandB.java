package kizuki.ac.check.impl.hand;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import kizuki.ac.packet.wrapper.*;

public class HandB extends KizukiCheck
{
    float buffer;
    boolean sent;
    
    public HandB(final PlayerData playerData) {
        super(playerData, CheckType.HAND, "Hand (B)", "HandB", DevelopmentState.EXPERIMENTAL, true);
        this.buffer = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketDig) {
            final CPacketDig cPacketDig = (CPacketDig)packet;
            if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.START_DESTROY_BLOCK)) {
                this.sent = true;
            }
            else if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.ABORT_DESTROY_BLOCK)) {
                this.sent = false;
            }
            else if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.STOP_DESTROY_BLOCK)) {
                this.sent = false;
            }
        }
        else if (packet instanceof CPacketFlying) {
            final float deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
            final float abs = Math.abs(((CPacketFlying)packet).getDeltaPitch());
            final boolean b = (deltaYaw < 1.0E-8 && deltaYaw > 1.0E-50) || (abs < 1.0E-8 && abs > 1.0E-50);
            final boolean b2 = this.getPlayerData().iI() || this.getPlayerData().sinceVehicleTicks < 3;
            if (b && !b2) {
                final float buffer = this.buffer;
                this.buffer = buffer + 1.0f;
                if (buffer > 3.0f) {
                    this.flag("a -> " + deltaYaw + ", b -> " + abs);
                }
            }
            else {
                this.buffer = Math.max(0.0f, this.buffer - 0.1f);
            }
        }
    }
}
