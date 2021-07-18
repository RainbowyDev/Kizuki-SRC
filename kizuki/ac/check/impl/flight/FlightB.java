package kizuki.ac.check.impl.flight;

import kizuki.ac.check.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import org.bukkit.util.*;

public class FlightB extends KizukiCheck
{
    float buffer;
    CPacketFlying lastFlying;
    double lastDeltaY;
    boolean wasBool;
    int verbosePattern;
    
    public FlightB(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Flight (B)", "FlyB", DevelopmentState.FINAL, false);
        this.buffer = 0.0f;
        this.lastFlying = null;
        this.lastDeltaY = 0.0;
        this.wasBool = false;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.lastFlying != null) {
                final CPacketFlying lastFlying = this.lastFlying;
                if (lastFlying.getTo().getY() % 0.015625 != 0.0 && lastFlying.isGround() && ((CPacketFlying)packet).isGround()) {
                    this.debug("failed");
                }
                final boolean collidingWithEntity = lastFlying.isCollidingWithEntity();
                if (!lastFlying.getTo().ll()) {
                    ++this.verbosePattern;
                }
                else {
                    this.verbosePattern = 0;
                }
                final boolean b = !this.wasBool && !collidingWithEntity && !lastFlying.getTo().ii() && (lastFlying.isGround() || lastFlying.getTo().getY() % 0.015625 == 0.0) && !lastFlying.getFrom().ii();
                final boolean hasGivenVelocity = this.getPlayerData().hasGivenVelocity(lastFlying.getTo().toLocation().toVector());
                if ((b && this.verbosePattern > 1) || (lastFlying.isGround() && Math.abs(lastFlying.getDeltaY() - (this.lastDeltaY - 0.08) * 98.0) < 0.05 && !this.getPlayerData().II())) {
                    this.getPlayerData().II(lastFlying.getTo().toLocation().toVector());
                    if (!hasGivenVelocity) {
                        final float buffer = this.buffer;
                        this.buffer = buffer + 1.0f;
                        if (buffer > 3.0f) {
                            this.flag(lastFlying.getTo().getY() + "");
                            this.setback(new Vector(0.0, -0.3, 0.0), lastFlying.getFrom());
                        }
                    }
                }
                else {
                    this.II().addValue(-0.005f);
                    this.buffer = (float)Math.max(this.buffer - 0.025, 0.0);
                }
                this.lastDeltaY = lastFlying.getDeltaY();
                this.wasBool = lastFlying.isCollidingWithEntity();
            }
            this.lastFlying = (CPacketFlying)packet;
        }
    }
}
