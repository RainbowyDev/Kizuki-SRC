package kizuki.ac.check.impl.flight;

import kizuki.ac.check.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import org.bukkit.*;
import org.bukkit.util.*;
import kizuki.ac.packet.wrapper.*;
import java.util.*;

public class FlightA extends KizukiCheck
{
    final double verbosePattern = 0.06;
    double lastY;
    double lastMotionY;
    double lastLastDeltaY;
    double lastDeltaY;
    double lastPredicted;
    float verbosePattern;
    boolean lastEmpty;
    boolean lastSafe;
    EvictingList samples;
    private boolean lastBool;
    
    public FlightA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Flight (A)", "FlyA", DevelopmentState.FINAL, false);
        this.lastMotionY = 0.0;
        this.lastDeltaY = -69.0;
        this.lastDeltaY = -69.0;
        this.lastPredicted = -69.0;
        this.verbosePattern = 0.0f;
        this.lastEmpty = false;
        this.lastSafe = false;
        this.samples = new EvictingList(10, true);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            double lastPredicted = (this.lastDeltaY - 0.07999999821186066) * 0.9800000190734863;
            final boolean collidingWithEntity = ((CPacketFlying)packet).isCollidingWithEntity();
            final double deltaY = cPacketFlying.getDeltaY();
            if (Math.abs(lastPredicted) < 0.06) {
                lastPredicted = 0.0;
            }
            final int ii = this.getPlayerData().iI();
            final int n = (150 + this.getPlayerData().II()) / 50 + 1;
            final double n2 = (this.getPlayerData().II != null) ? this.getPlayerData().II.getY() : -69.0;
            int n3 = 0;
            if (this.getPlayerData().II != null) {
                if (this.getPlayerData().ll - this.getPlayerData().ii < 10L) {
                    this.debug("v -> " + this.getPlayerData().II.getY() + ", d -> " + deltaY);
                }
                n3 = ((n > ii && (Math.abs(deltaY - this.getPlayerData().II.getY()) < 0.03 || (this.getPlayerData().sneaking < 2 && Math.abs(deltaY - 0.42) < 0.015)) && n2 != -69.0) ? 1 : 0);
            }
            if (n3 != 0) {
                lastPredicted = this.getPlayerData().II.getY();
                this.lastSafe = true;
            }
            for (final Double n4 : this.samples) {
                if (Math.abs(n4 - deltaY) < 0.03) {
                    lastPredicted = n4;
                    break;
                }
            }
            if (!this.lastSafe) {
                if (n + 1 == ii && this.getPlayerData().II != null && this.getPlayerData().sinceBoundingBoxEmpty > 9 && this.getPlayerData().sinceHalfBlockTicks > 5 && this.getPlayerData().II.getY() > 0.0 && this.getPlayerData().II.getY() * this.getPlayerData().II.getY() > 0.03) {
                    final float verbosePattern = this.verbosePattern;
                    this.verbosePattern = verbosePattern + 1.0f;
                    if (verbosePattern > 1.0f) {
                        this.flag("ignored -> " + this.getPlayerData().II.getY());
                    }
                }
            }
            final boolean b = (this.getPlayerData().sneaking > 2 || (this.getPlayerData().sneaking > 1 && Math.abs(this.lastDeltaY - this.getPlayerData().getJumpMotion()) < 0.015) || (deltaY < lastPredicted - 0.01 && this.getPlayerData().groundTicks == 1 && this.getPlayerData().sprinting > 1)) && this.lastDeltaY != 69.0 && this.lastPredicted != 69.0;
            final boolean b2 = this.getPlayerData().sinceBoundingBoxEmpty < 3 || this.getPlayerData().sinceLiquidTicks < 5 || this.getPlayerData().iI() || BlockUtils.isLocationCollidingWithClimbable(cPacketFlying.getTo().toLocation()) || this.getPlayerData().sinceVehicleTicks < 4 || this.getPlayerData().iI < 50 || this.getPlayerData().Il() || this.getPlayerData().II() || this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) || this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) || BlockUtils.isLocationWeb(((CPacketFlying)packet).getTo().toLocation());
            this.debug(deltaY + "");
            final boolean b3 = Math.abs(lastPredicted - deltaY) > ((BlockUtils.isOnSlime(this.getPlayerData()) || (this.getPlayerData().iI() < 12 && this.getPlayerData().II != null && this.getPlayerData().II.getY() > 0.0 && cPacketFlying.getDeltaXZ() < 0.01)) ? 0.4 : 0.06);
            double lastDeltaY = this.lastDeltaY;
            double y = cPacketFlying.getFrom().getY();
            int n5 = 0;
            double n6;
            boolean b4;
            do {
                n6 = lastDeltaY;
                lastDeltaY = (lastDeltaY - 0.08) * 0.98;
                y += lastDeltaY;
                b4 = (++n5 > 1 && ((CPacketFlying)packet).getDeltaXZ() < 0.003);
            } while (lastDeltaY * lastDeltaY < 9.0E-4);
            final boolean b5 = b3 && Math.abs(cPacketFlying.getTo().getY() - y) > 0.01 && Math.abs(cPacketFlying.getTo().getY() - y + Math.abs(n6)) > 0.001 && Math.abs(cPacketFlying.getTo().getY() - y - this.lastMotionY) > 0.001;
            this.lastY = y;
            this.lastMotionY = lastDeltaY;
            final double n7 = (this.lastDeltaY - 0.08) * 0.98 - 0.005;
            if (deltaY < n7 && !b4 && Math.abs(n7) > 0.005 && !this.lastBool && !collidingWithEntity && this.getPlayerData().sinceVehicleTicks > 3 && !BlockUtils.isOnSlime(this.getPlayerData()) && !this.getPlayerData().hasGivenVelocity(((CPacketFlying)packet).getTo().toLocation().toVector()) && !BlockUtils.isLocationCollidingWithClimbable(((CPacketFlying)packet).getTo().toLocation()) && !((CPacketFlying)packet).isMathematicallyGround() && !this.getPlayerData().iI(-6) && this.getPlayerData().sinceBoundingBoxEmpty > 3 && !this.getPlayerData().iI() && !BlockUtils.isLocationWeb(((CPacketFlying)packet).getTo().toLocation()) && !this.getPlayerData().getPlayer().getAllowFlight()) {
                this.flag("yport -> " + deltaY + ", p -> " + ((this.lastDeltaY - 0.08) * 0.98 - 0.001));
            }
            if (b && !b2 && b5 && BlockUtils.Ii(((CPacketFlying)packet).getTo().toLocation())) {
                final float verbosePattern2 = this.verbosePattern;
                this.verbosePattern = verbosePattern2 + 1.0f;
                if (verbosePattern2 > 2.0f) {
                    this.flag("a -> " + Math.abs(lastPredicted - deltaY) + "; b -> " + deltaY + ", c -> " + lastPredicted, (float)(1.0 + Math.abs(lastPredicted - deltaY)));
                }
                this.setback(new Vector(0.0, -0.1 * this.getPlayerData().sneaking, 0.0), cPacketFlying.getFrom());
            }
            else {
                this.verbosePattern = Math.max(0.0f, this.verbosePattern - 0.005f);
                this.II().addValue(-0.015f);
            }
            this.lastBool = collidingWithEntity;
            this.lastLastDeltaY = this.lastDeltaY;
            this.lastDeltaY = (this.getPlayerData().II((CPacketFlying)packet) ? lastPredicted : deltaY);
            this.lastPredicted = lastPredicted;
            this.lastEmpty = cPacketFlying.getTo().isBoundingBoxEmptyTall();
        }
        else if (packet instanceof SPacketEntityVelocity) {
            this.samples.add(((SPacketEntityVelocity)packet).getVelocity().getY());
            this.lastSafe = false;
        }
    }
}
