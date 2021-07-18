package kizuki.ac.check.impl.inventory;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.util.*;
import kizuki.ac.*;

public class InventoryA extends KizukiCheck
{
    long verbosePattern;
    boolean iI;
    boolean Ii;
    boolean ii;
    double verbosePattern;
    double iI;
    int verbosePattern;
    
    public InventoryA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "InventoryMove (A)", "InvMoveA", DevelopmentState.FINAL, false);
        this.verbosePattern = Long.MAX_VALUE;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            if (this.getTime() - this.verbosePattern - this.getPlayerData().II() > 150L && !this.getPlayerData().II() && !this.getPlayerData().iI(-5) && !cPacketFlying.getTo().isInLiquid()) {
                if (!cPacketFlying.isGround() && !this.iI && !this.Ii && !cPacketFlying.getTo().isFull()) {
                    final double hypot = Math.hypot(cPacketFlying.getDeltaX() - this.verbosePattern * 0.91, cPacketFlying.getDeltaZ() - this.iI * 0.91);
                    if (hypot > 0.008 && this.verbosePattern++ > 0) {
                        this.flag("g -> " + hypot);
                    }
                }
                if (cPacketFlying.isGround() && this.iI && this.Ii && !cPacketFlying.getTo().isFull()) {
                    if (cPacketFlying.getTo().II() == null) {
                        return;
                    }
                    final float ii = this.getPlayerData().II((CPacketFlying)packet);
                    final double hypot2 = Math.hypot(cPacketFlying.getDeltaX() - this.verbosePattern * 0.91 * ii, cPacketFlying.getDeltaZ() - this.iI * 0.91 * ii);
                    if (hypot2 > 0.09) {
                        if (this.verbosePattern++ > 0) {
                            this.flag("g -> " + hypot2);
                        }
                        if (config.II(this.Ii() + ".setback")) {
                            this.setback(new Vector((cPacketFlying.getTo().getX() - cPacketFlying.getFrom().getX()) / -2.0, ((CPacketFlying)packet).getDeltaY(), (cPacketFlying.getTo().getZ() - cPacketFlying.getFrom().getZ()) / -2.0), ((CPacketFlying)packet).getFrom());
                        }
                    }
                }
            }
            this.verbosePattern = cPacketFlying.getDeltaX();
            this.iI = cPacketFlying.getDeltaZ();
            this.Ii = this.iI;
            this.iI = cPacketFlying.isGround();
        }
        else if (packet instanceof uu) {
            this.verbosePattern = this.getTime();
        }
        else if (packet instanceof ut) {
            this.verbosePattern = this.getTime();
            this.ii = true;
        }
        else if (packet instanceof uy || packet instanceof uo) {
            this.verbosePattern = Long.MAX_VALUE;
            this.ii = false;
        }
    }
}
