package kizuki.ac.check.impl.speed;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import org.bukkit.*;
import org.bukkit.util.*;
import kizuki.ac.packet.wrapper.*;

public class SpeedB extends KizukiCheck
{
    boolean iI;
    double verbosePattern;
    boolean Ii;
    float verbosePattern;
    
    public SpeedB(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Speed (B)", "SpeedB", DevelopmentState.FINAL, false);
        this.iI = false;
        this.verbosePattern = 0.0;
        this.Ii = false;
        this.verbosePattern = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final boolean ii = this.getPlayerData().II((CPacketFlying)packet);
            final boolean world = cPacketFlying.getWorld();
            final double n = cPacketFlying.getDeltaXZ() - this.verbosePattern * 0.91 - ((this.getPlayerData().sinceSprintTicks < 2 || this.getPlayerData().sprinting) ? 0.0254 : 0.02);
            int n2 = ((this.getPlayerData().sneaking > 1 || (this.getPlayerData().groundTicks == 1 && this.getPlayerData().sprinting > 2)) && cPacketFlying.getDeltaXZ() > 0.125 && !this.getPlayerData().iI() && this.getPlayerData().iI > 10 && this.getPlayerData().sinceVehicleTicks > 3 && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && !ii && !world && this.getPlayerData().Ii > 2 && !this.iI && !((CPacketFlying)packet).getTo().isInLiquid() && !this.getPlayerData().getPlayer().isFlying()) ? 1 : 0;
            if (n2 != 0) {
                if (n > 0.001 && !this.getPlayerData().getPlayer().getAllowFlight() && !this.getPlayerData().iI(this.getPlayerData().Ii() / 10)) {
                    final float verbosePattern = this.verbosePattern;
                    this.verbosePattern = verbosePattern + 1.0f;
                    if (verbosePattern <= 2.0f) {
                        n2 = 0;
                    }
                    if (n > 0.0021) {
                        n2 = 1;
                    }
                }
                else {
                    n2 = 0;
                    this.verbosePattern = Math.max(this.verbosePattern - 0.25f, 0.0f);
                }
            }
            if (n2 != 0 && !((CPacketFlying)packet).getTo().isFull()) {
                this.setback(new Vector((((CPacketFlying)packet).getTo().getX() - ((CPacketFlying)packet).getFrom().getX()) / -3.0, (((CPacketFlying)packet).getDeltaY() - 0.08) * 0.98, (((CPacketFlying)packet).getTo().getZ() - ((CPacketFlying)packet).getFrom().getZ()) / -3.0), ((CPacketFlying)packet).getFrom());
                this.flag("d -> " + n + ", a -> " + n);
            }
            this.verbosePattern = cPacketFlying.getDeltaXZ();
            this.iI = world;
        }
        else if (packet instanceof SPacketEntityVelocity) {
            this.Ii = false;
        }
    }
}
