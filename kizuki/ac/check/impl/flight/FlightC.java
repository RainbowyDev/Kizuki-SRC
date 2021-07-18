package kizuki.ac.check.impl.flight;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import org.bukkit.*;
import org.bukkit.util.*;
import kizuki.ac.packet.wrapper.*;

public class FlightC extends KizukiCheck
{
    int verbosePattern;
    int iI;
    int Ii;
    int ii;
    int ll;
    double verbosePattern;
    
    public FlightC(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Flight (C)", "FlyC", DevelopmentState.FINAL, false);
        this.verbosePattern = 0;
        this.iI = 0;
        this.Ii = 0;
        this.ii = 0;
        this.ll = 6;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final double deltaY = ((CPacketFlying)packet).getDeltaY();
            if (((CPacketFlying)packet).isCollidingWithEntity() || ((CPacketFlying)packet).getTo().ll() || ((CPacketFlying)packet).getTo().getY() % 0.015625 == 0.0) {
                this.Ii = 0;
            }
            else {
                ++this.Ii;
            }
            if (((CPacketFlying)packet).isGround()) {
                this.verbosePattern = 0;
                this.iI = 0;
                this.ll = 8 + this.getPlayerData().II() / 50 / 3 + this.getPlayerData().getPotionLevel("JUMP");
            }
            else {
                ++this.iI;
                ++this.verbosePattern;
            }
            if (this.getPlayerData().getPlayer().isInsideVehicle() || this.getPlayerData().hasGivenVelocity(((CPacketFlying)packet).getTo().toLocation().toVector()) || BlockUtils.isLocationCollidingWithClimbable(((CPacketFlying)packet).getTo().toLocation()) || ((CPacketFlying)packet).getTo().isInLiquid() || BlockUtils.isLocationWeb(((CPacketFlying)packet).getTo().toLocation()) || this.getPlayerData().II() || this.getPlayerData().iI() || this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) || this.getPlayerData().iI < 20) {
                this.verbosePattern = 0;
                this.Ii = 0;
            }
            final boolean b = (((this.Ii > this.ll && deltaY >= -0.05) || (this.Ii > this.ll + 40 && deltaY >= -0.5)) && !BlockUtils.isOnSlime(this.getPlayerData())) || ((this.getPlayerData().II == null || this.getPlayerData().II.getY() > 0.0) && deltaY < (Math.pow(0.98, this.getPlayerData().sprinting + 1) - 1.0) * 3.92 - 0.01 && (this.iI > 0 || this.getPlayerData().sprinting >= 1) && !this.getPlayerData().II()) || (this.verbosePattern * 0.95 < deltaY && deltaY > -3.9 && this.verbosePattern > 5 && !this.getPlayerData().ii());
            this.debug("l " + this.ll + " s " + this.Ii);
            if (b && BlockUtils.Ii(((CPacketFlying)packet).getTo().toLocation()) && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !this.getPlayerData().iI() && this.getPlayerData().iI > 15 && !this.getPlayerData().Il()) {
                this.flag("aT -> " + ((Math.pow(0.98, this.iI) - 1.0) * 3.92 - 0.01) + ", dY -> " + deltaY + ", l -> " + this.ll + ", a -> " + this.Ii + ", uat -> " + this.iI);
                this.setback(new Vector(0.0, -0.1 * this.getPlayerData().sneaking, 0.0), ((CPacketFlying)packet).getFrom());
            }
            else {
                this.II().addValue(-0.005f);
            }
            this.verbosePattern = deltaY;
        }
        else if (packet instanceof SPacketEntityVelocity) {
            double y = ((SPacketEntityVelocity)packet).getVelocity().getY();
            if (y > -0.005) {
                int n = 7;
                do {
                    y = (y - 0.08) * 0.98;
                    ++n;
                } while (y > -0.005);
                this.debug("ticks -> " + n + ", y -> " + ((SPacketEntityVelocity)packet).getVelocity().getY());
                this.ll += n;
            }
        }
    }
}
