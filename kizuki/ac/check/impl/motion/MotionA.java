package kizuki.ac.check.impl.motion;

import kizuki.ac.check.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import org.bukkit.util.*;
import kizuki.ac.packet.wrapper.*;
import java.util.*;
import kizuki.ac.utils.*;
import org.bukkit.block.*;

public class MotionA extends KizukiCheck
{
    boolean iI;
    boolean Ii;
    boolean ii;
    boolean ll;
    EvictingList verbosePattern;
    float verbosePattern;
    private boolean lI;
    
    public MotionA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Motion (A)", "MotionA", DevelopmentState.FINAL, false);
        this.iI = false;
        this.Ii = false;
        this.ii = false;
        this.ll = false;
        this.verbosePattern = new EvictingList(3, true);
        this.verbosePattern = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final boolean collidingWithEntity = ((CPacketFlying)packet).isCollidingWithEntity();
            final boolean ii = this.II(((CPacketFlying)packet).getTo());
            final double deltaY = ((CPacketFlying)packet).getDeltaY();
            final String lowerCase = ((CPacketFlying)packet).getFrom().iI().toString().toLowerCase();
            final boolean b = this.getPlayerData().sinceHalfBlockTicks < 2 || lowerCase.contains("fence") || lowerCase.contains("wall");
            final boolean boundingBoxEmptyTall = ((CPacketFlying)packet).getTo().isBoundingBoxEmptyTall();
            final boolean b2 = ((CPacketFlying)packet).isPos() && this.getPlayerData().sinceSlimeOrBedTicks > 10 && !this.getPlayerData().getPlayer().isFlying() && !this.getPlayerData().getPlayer().isInsideVehicle() && !BlockUtils.isLocationCollidingWithClimbable(((CPacketFlying)packet).getTo().toLocation()) && !((CPacketFlying)packet).isGround() && !((CPacketFlying)packet).getTo().isInLiquid() && this.ii && !this.ll && !boundingBoxEmptyTall && !this.lI && !collidingWithEntity && !this.getPlayerData().iI() && !this.getPlayerData().ii() && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !BlockUtils.isLocationWeb(((CPacketFlying)packet).getTo().toLocation());
            if (this.getPlayerData().II != null) {
                this.debug("dY -> " + ((CPacketFlying)packet).getDeltaY() + ", l -> " + this.getPlayerData().II.getY());
            }
            Label_0943: {
                if (b2) {
                    final double n = this.getPlayerData().getPotionLevel("JUMP") * 0.1;
                    final boolean b3 = ii ? (deltaY > 0.6) : ((deltaY > 0.0 && deltaY < 0.4199 + n) || deltaY > 0.4200001 + n);
                    final boolean b4 = ii ? (deltaY > 0.6) : ((deltaY > 0.0 && deltaY < 0.332 + n) || deltaY > 0.4200001 + n);
                    final boolean b5 = this.Ii || ii;
                    if (b3 || b4) {
                        for (final Double n2 : this.verbosePattern) {
                            if (Math.abs(n2 - deltaY) < 0.001) {
                                this.verbosePattern.remove(n2);
                                break Label_0943;
                            }
                        }
                    }
                    if (b4 && !b5) {
                        if (b && deltaY % 0.015625 == 0.0 && deltaY < 0.6) {
                            break Label_0943;
                        }
                        final float verbosePattern = this.verbosePattern;
                        this.verbosePattern = verbosePattern + 1.0f;
                        if (verbosePattern > 0.0f || deltaY > 0.6) {
                            this.flag("a -> " + deltaY + ", b -> " + ((this.getPlayerData().II == null) ? -69.0 : this.getPlayerData().II.getY()));
                            this.setback(new Vector(-(((CPacketFlying)packet).getTo().getX() - ((CPacketFlying)packet).getFrom().getX()), -deltaY, -(((CPacketFlying)packet).getTo().getZ() - ((CPacketFlying)packet).getFrom().getZ())), ((CPacketFlying)packet).getFrom());
                        }
                    }
                    else {
                        this.verbosePattern = Math.max(this.verbosePattern - 0.025f, 0.0f);
                    }
                    if (b3 && !b4 && !b5 && !this.iI) {
                        if (b && deltaY % 0.015625 == 0.0 && deltaY < 0.6) {
                            break Label_0943;
                        }
                        final float verbosePattern2 = this.verbosePattern;
                        this.verbosePattern = verbosePattern2 + 1.0f;
                        if (verbosePattern2 > 0.0f || deltaY > 0.6) {
                            this.flag("tw/mY -> " + deltaY + ", a -> " + ((this.getPlayerData().II == null) ? -69.0 : this.getPlayerData().II.getY()));
                        }
                    }
                    else {
                        this.verbosePattern = Math.max(this.verbosePattern - 0.1f, 0.0f);
                    }
                    this.iI = false;
                }
            }
            this.lI = collidingWithEntity;
            this.ii = ((CPacketFlying)packet).isGround();
            this.Ii = ii;
            this.ll = boundingBoxEmptyTall;
        }
        else if (packet instanceof CPacketBlockPlace) {
            this.iI = true;
        }
        else if (packet instanceof SPacketEntityVelocity) {
            this.verbosePattern.add(((SPacketEntityVelocity)packet).getVelocity().getY());
        }
    }
    
    boolean II(final LocationUtil locationUtil) {
        final double n = 0.3;
        try {
            for (double n2 = -n; n2 <= n; n2 += n) {
                for (double n3 = -n; n3 <= n; n3 += n) {
                    final Block block = BlockUtils.getBlock(locationUtil.toLocation().clone().add(n2, 0.0, n3));
                    if (block == null) {
                        return true;
                    }
                    if (block.getType().isSolid()) {
                        return true;
                    }
                    final Block block2 = BlockUtils.getBlock(locationUtil.toLocation().clone().add(n2, 1.0, n3));
                    if (block2 == null) {
                        return false;
                    }
                    if (block2.getType().isSolid()) {
                        return true;
                    }
                    final Block block3 = BlockUtils.getBlock(locationUtil.toLocation().clone().add(n2, 1.7999, n3));
                    if (block3 == null) {
                        return false;
                    }
                    if (block3.getType().isSolid()) {
                        return true;
                    }
                }
            }
        }
        catch (Exception ex) {
            return false;
        }
        return false;
    }
}
