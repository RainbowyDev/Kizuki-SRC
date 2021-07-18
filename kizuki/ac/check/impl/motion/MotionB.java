package kizuki.ac.check.impl.motion;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import java.util.stream.*;
import org.bukkit.util.*;

public class MotionB extends KizukiCheck
{
    double verbosePattern;
    double iI;
    int verbosePattern;
    
    public MotionB(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Motion (B)", "MotionB", DevelopmentState.FINAL, false);
        this.verbosePattern = 0.0;
        this.iI = 0.0;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final double deltaY = ((CPacketFlying)packet).getDeltaY();
            final double deltaXZ = ((CPacketFlying)packet).getDeltaXZ();
            final boolean inLiquid = ((CPacketFlying)packet).getTo().isInLiquid();
            final boolean b2 = deltaXZ > 0.29 && this.getPlayerData().sneaking != 0 && this.iI == deltaXZ && !inLiquid && !this.getPlayerData().iI();
            final boolean b3 = Math.abs(deltaY) > 0.1 && deltaY == -this.verbosePattern && !this.getPlayerData().iI() && this.getPlayerData().sinceSlimeOrBedTicks > 5 && (this.getPlayerData().II == null || this.getPlayerData().II.getY() > 0.0);
            final boolean b4 = deltaY > 0.60001 && ((CPacketFlying)packet).isGround() && this.getPlayerData().sinceSlimeOrBedTicks > 5;
            final boolean b5 = deltaY < -3.95 && !this.getPlayerData().iI();
            boolean b6 = false;
            if (Math.abs(deltaY - this.verbosePattern) < 0.1 && !((CPacketFlying)packet).getTo().ll() && !inLiquid && !this.getPlayerData().iI()) {
                b6 = (Math.min(this.verbosePattern + 1, 6) > 3);
            }
            else {
                this.verbosePattern = Math.max(0, this.verbosePattern - 1);
            }
            if (!this.getPlayerData().iI() && !this.getPlayerData().II() && this.getPlayerData().iI > 3 && (b2 || b3 || b6 || b4 || b5)) {
                this.flag("a -> " + deltaY + ", b -> " + deltaXZ + ", c -> " + this.verbosePattern + ", d -> " + this.iI, (float)Stream.of(new Boolean[] { b2, b3, b6, b4, b5 }).filter(b -> b).toArray().length);
                this.setback(new Vector(-(((CPacketFlying)packet).getTo().getX() - ((CPacketFlying)packet).getFrom().getX()), -deltaY, -(((CPacketFlying)packet).getTo().getZ() - ((CPacketFlying)packet).getFrom().getZ())), ((CPacketFlying)packet).getFrom());
            }
            this.verbosePattern = deltaY;
            this.iI = deltaXZ;
        }
    }
}
