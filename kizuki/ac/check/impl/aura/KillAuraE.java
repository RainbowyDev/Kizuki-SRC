package kizuki.ac.check.impl.aura;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import kizuki.ac.packet.wrapper.*;

public class KillAuraE extends KizukiCheck
{
    int tick;
    boolean sent;
    long verbosePattern;
    long timestamp;
    int buffer;
    int arm;
    
    public KillAuraE(final PlayerData playerData) {
        super(playerData, CheckType.KILLAURA, "KillAura (E)", "KillAuraE", DevelopmentState.FINAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketUseEntity) {
            final CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)packet;
            if (cPacketUseEntity.getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK)) {
                if (this.tick != cPacketUseEntity.getFace()) {
                    this.sent = true;
                    this.verbosePattern = this.getTime() - this.timestamp;
                }
                this.tick = cPacketUseEntity.getFace();
                this.timestamp = this.getTime();
            }
        }
        else if (packet instanceof CPacketFlying) {
            final double n = ((CPacketFlying)packet).getDeltaYaw();
            if (this.sent) {
                if (this.verbosePattern < 175L && n > 20.0 && this.arm < 3) {
                    if (this.buffer++ > 0) {
                        this.flag("a -> " + n + ", b -> " + this.verbosePattern);
                    }
                }
                else {
                    this.buffer = Math.max(this.buffer - 1, 0);
                }
                this.sent = false;
                this.arm = 0;
            }
        }
        else if (packet instanceof CPacketArmAnimation) {
            ++this.arm;
        }
        else if (packet instanceof CPacketDig) {
            ++this.arm;
        }
    }
}
