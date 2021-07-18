package kizuki.ac.check.impl.aura;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;

public class KillAuraA extends KizukiCheck
{
    int use;
    int arm;
    
    public KillAuraA(final PlayerData playerData) {
        super(playerData, CheckType.KILLAURA, "KillAura (A)", "KillAuraA", DevelopmentState.FINAL, false);
        this.use = 0;
        this.arm = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            ++this.arm;
            this.debug("sw " + this.arm);
        }
        else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction() == EnumWrappers$EntityUseAction.ATTACK && ++this.use >= 3) {
            if (Math.abs(this.use - this.arm) > 1 && this.arm < this.use) {
                this.flag("a -> " + this.arm + ", b -> " + this.use);
            }
            final int n = 0;
            this.use = n;
            this.arm = n;
        }
    }
}
