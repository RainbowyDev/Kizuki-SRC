package kizuki.ac.check.impl.aura;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;

public class KillAuraD extends KizukiCheck
{
    private Double deltaXZ;
    private Integer ticksA;
    private Integer ticksB;
    private Float deltaYaw;
    
    public KillAuraD(final PlayerData playerData) {
        super(playerData, CheckType.KILLAURA, "KillAura (D)", "KillAuraD", DevelopmentState.FINAL, false);
        this.deltaXZ = 0.0;
        this.ticksA = 0;
        this.ticksB = 0;
        this.deltaYaw = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            this.deltaXZ = ((CPacketFlying)packet).getDeltaXZ();
            this.deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
        }
        else if ((this.deltaXZ > 0.33 && this.deltaYaw > 7.5) || this.deltaYaw > 20.0f) {
            if (packet instanceof CPacketArmAnimation) {
                final Integer ticksA = this.ticksA;
                ++this.ticksA;
            }
            else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK)) {
                if (((CPacketUseEntity)packet).getEntity() != null && ((CPacketUseEntity)packet).getEntity().getLocation().distance(this.getPlayerData().getPlayer().getLocation()) < 1.0) {
                    --this.ticksA;
                    --this.ticksB;
                }
                final Integer ticksB = this.ticksB;
                ++this.ticksB;
                if (this.ticksA >= 40) {
                    final long n = this.ticksA - this.ticksB;
                    this.debug(n + "");
                    if (n <= 2L) {
                        this.flag(String.format("a -> %s", n));
                    }
                    else {
                        this.ticksA = 0;
                        this.ticksB = 0;
                    }
                }
            }
        }
    }
}
