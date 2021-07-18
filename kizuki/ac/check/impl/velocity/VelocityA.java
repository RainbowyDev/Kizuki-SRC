package kizuki.ac.check.impl.velocity;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;

public class VelocityA extends KizukiCheck
{
    boolean iI;
    double verbosePattern;
    
    public VelocityA(final PlayerData playerData) {
        super(playerData, CheckType.VELOCITY, "Velocity (A)", "VelocityA", DevelopmentState.FINAL, false);
        this.iI = false;
        this.verbosePattern = 0.0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final boolean b = this.getPlayerData().II((CPacketFlying)packet) && !this.getPlayerData().iI();
            final double deltaXZ = ((CPacketFlying)packet).getDeltaXZ();
            if (b) {
                if (this.getPlayerData().II.ii() >= 0.22) {
                    final double deltaY = ((CPacketFlying)packet).getDeltaY();
                    double abs = Math.abs(this.verbosePattern / 2.0 - this.getPlayerData().II.ii() * 0.91 - ((this.getPlayerData().sinceSprintTicks < 2 || this.getPlayerData().sprinting) ? 0.0254 : 0.02));
                    if (this.getPlayerData().hitTicks == 1) {
                        abs *= 0.6;
                    }
                    if (this.getPlayerData().sneaking < 3) {
                        abs *= 0.216;
                    }
                    final boolean b2 = deltaXZ < abs && Math.abs(deltaY - 0.42) > 0.01 && !BlockUtils.isLocationCollidingWithClimbable(((CPacketFlying)packet).getTo().toLocation()) && !((CPacketFlying)packet).getTo().isFull();
                    final double n = this.verbosePattern * 0.91 - ((this.getPlayerData().sinceSprintTicks < 2 || this.getPlayerData().sprinting) ? 0.0254 : 0.02);
                    this.debug(abs + " d -> " + deltaXZ + " p -> " + n + " last -> " + this.verbosePattern + " lol " + (this.getPlayerData().II.ii() - this.verbosePattern - n));
                    final float n2 = (float)(deltaXZ / abs * 100.0);
                    if (b2) {
                        this.flag("p -> " + n2 + "%, a -> " + this.getPlayerData().sneaking);
                    }
                }
            }
            this.verbosePattern = deltaXZ;
        }
        else if (packet instanceof SPacketEntityVelocity) {
            this.iI = false;
        }
    }
}
