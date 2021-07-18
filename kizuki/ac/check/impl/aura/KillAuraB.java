package kizuki.ac.check.impl.aura;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;
import org.bukkit.entity.*;

public class KillAuraB extends KizukiCheck
{
    double lastDeltaXZ;
    int ticks;
    int buffer;
    
    public KillAuraB(final PlayerData playerData) {
        super(playerData, CheckType.KILLAURA, "KillAura (B)", "KillAuraB", DevelopmentState.FINAL, false);
        this.lastDeltaXZ = 0.0;
        this.ticks = 0;
        this.buffer = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final double deltaXZ = ((CPacketFlying)packet).getDeltaXZ();
            if (this.buffer++ <= 3 && deltaXZ > 0.25) {
                final double abs = Math.abs(deltaXZ - this.lastDeltaXZ);
                if (abs < 7.5E-4 && abs != 0.0) {
                    if (this.ticks++ > 10) {}
                }
                else {
                    this.ticks = 0;
                }
            }
            this.lastDeltaXZ = deltaXZ;
        }
        else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK) && ((CPacketUseEntity)packet).getEntity() != null && ((CPacketUseEntity)packet).getEntity() instanceof Player) {
            this.buffer = 0;
        }
    }
}
