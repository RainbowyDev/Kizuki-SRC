package kizuki.ac.check.impl.speed;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.*;
import org.bukkit.util.*;

public class SpeedC extends KizukiCheck
{
    private float verbosePattern;
    private int verbosePattern;
    private boolean iI;
    private double verbosePattern;
    
    public SpeedC(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Speed (C)", "SpeedC", DevelopmentState.FINAL, false);
        this.verbosePattern = 0.0f;
        this.verbosePattern = 0;
        this.iI = false;
        this.verbosePattern = 0.0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final boolean ground = cPacketFlying.isGround();
            final double deltaXZ = cPacketFlying.getDeltaXZ();
            if (!ground || !this.iI) {
                final double n = (deltaXZ - this.verbosePattern) / ((this.getPlayerData().sprinting || this.getPlayerData().sinceSprintTicks < 2) ? 0.026 : 0.02);
                final boolean b = this.getPlayerData().II != null && this.getPlayerData().iI(this.getPlayerData().Ii() / 10);
                if (this.getPlayerData().II != null) {
                    this.debug(b + " " + this.getPlayerData().II.ii());
                }
                if (n > 1.0 && this.getPlayerData().sinceBoundingBoxEmpty > 5 && !this.getPlayerData().iI() && !this.getPlayerData().II() && this.getPlayerData().sinceVehicleTicks > 3 && this.getPlayerData().sinceHalfBlockTicks > 5 && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !b) {
                    final float verbosePattern = this.verbosePattern;
                    this.verbosePattern = verbosePattern + 1.0f;
                    if (verbosePattern > 3.0f) {
                        this.setback(new Vector((((CPacketFlying)packet).getTo().getX() - ((CPacketFlying)packet).getFrom().getX()) / -2.0, (((CPacketFlying)packet).getDeltaY() - 0.08) * 0.98, (((CPacketFlying)packet).getTo().getZ() - ((CPacketFlying)packet).getFrom().getZ()) / -2.0), ((CPacketFlying)packet).getFrom());
                        this.flag("a -> " + ((CPacketFlying)packet).getDeltaXZ() + ", s -> " + n + ", v -> " + ((this.getPlayerData().II != null) ? this.getPlayerData().II.ii() : 0.0));
                        this.verbosePattern /= 1.5;
                    }
                }
                else {
                    this.verbosePattern = 0;
                }
            }
            this.verbosePattern = deltaXZ * 0.9100000262260437;
            this.verbosePattern = Math.max(this.verbosePattern - 0.25f, 0.0f);
            this.iI = ground;
        }
    }
}
