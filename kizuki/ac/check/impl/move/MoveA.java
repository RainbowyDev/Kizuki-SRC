package kizuki.ac.check.impl.move;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.utils.*;
import org.bukkit.util.*;
import org.bukkit.block.*;

public class MoveA extends KizukiCheck
{
    double verbosePattern;
    double iI;
    boolean iI;
    boolean Ii;
    boolean ii;
    boolean ll;
    double Ii;
    double ii;
    
    public MoveA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Move (A)", "MoveA", DevelopmentState.FINAL, false);
        this.verbosePattern = 0.0;
        this.iI = 0.0;
        this.iI = false;
        this.Ii = 0.0;
        this.ii = 0.0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final double verbosePattern = cPacketFlying.getTo().getX() - cPacketFlying.getFrom().getX();
            final double ii = cPacketFlying.getTo().getZ() - cPacketFlying.getFrom().getZ();
            final boolean world = cPacketFlying.getWorld();
            final boolean b = !this.getPlayerData().II() && !this.getPlayerData().getPlayer().isInsideVehicle() && !cPacketFlying.getTo().iI() && !this.Ii && this.getPlayerData().sinceVehicleTicks > 3 && this.getPlayerData().sinceLiquidTicks > 3 && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !world && !this.iI && !this.getPlayerData().ll();
            final boolean full = cPacketFlying.getTo().isFull();
            Label_0838: {
                if (b && !full) {
                    final boolean b2 = !((CPacketFlying)packet).isGround() && !this.ii && !this.ll;
                    this.debug("a " + b2);
                    final boolean b3 = ((CPacketFlying)packet).isGround() && this.ii && this.ll;
                    final Block block = BlockUtils.getBlock(((CPacketFlying)packet).getTo().toLocation().clone().add(0.0, -0.2, 0.0));
                    if (block != null) {
                        if (((CPacketFlying)packet).isGround() && !block.getType().isSolid() && this.getPlayerData().sneaking) {
                            this.Ii = 0.0;
                            this.debug("broke the check");
                        }
                        else {
                            final float ii2 = this.getPlayerData().II((CPacketFlying)packet);
                            double n;
                            double n2;
                            if (b3) {
                                n = this.verbosePattern * ii2;
                                n2 = this.iI * ii2;
                            }
                            else {
                                if (!b2) {
                                    break Label_0838;
                                }
                                n = this.verbosePattern * 0.91;
                                n2 = this.iI * 0.91;
                            }
                            final double n3 = verbosePattern - n;
                            final double n4 = ii - n2;
                            this.debug(MathUtil.Ii(n3, n4) + "");
                            if (MathUtil.Ii(n3, n4) >= (b2 ? 0.021 : 0.09)) {
                                final float n5 = (float)Math.toDegrees(Math.atan2(n4, n3));
                                final float n6 = ((CPacketFlying)packet).getTo().getYaw() + 90.0f;
                                final double ii3 = MathUtil.II((n5 < 0.0f) ? (n5 + 360.0f) : n5, (n6 < 0.0f) ? (360.0f + n6 % 360.0f) : (n6 % 360.0f));
                                this.debug(ii3 + "");
                                if (((ii3 % 45.0 > 12.0 && ii3 % 45.0 < 33.5) || (this.getPlayerData().sprinting && ii3 > 57.0)) && ((CPacketFlying)packet).getDeltaXZ() > 0.05) {
                                    if (this.Ii == 1.0) {
                                        this.getPlayerData().getPlayer().setSprinting(false);
                                    }
                                    final double ii4 = this.Ii;
                                    this.Ii = ii4 + 1.0;
                                    if (ii4 > 2.0) {
                                        this.flag("a -> " + ii3);
                                        if (config.II(this.Ii() + ".setback")) {
                                            this.setback(new Vector(verbosePattern / -2.0, ((CPacketFlying)packet).getDeltaY(), ii / -2.0), ((CPacketFlying)packet).getFrom());
                                        }
                                    }
                                }
                                else if (this.Ii < 3.0) {
                                    this.Ii = 0.0;
                                }
                                else {
                                    --this.Ii;
                                }
                            }
                        }
                    }
                }
            }
            this.verbosePattern = verbosePattern;
            this.iI = ii;
            this.ii = cPacketFlying.getDeltaXZ();
            this.ll = this.ii;
            this.iI = world;
            this.ii = cPacketFlying.isGround();
            this.Ii = cPacketFlying.getTo().iI();
        }
    }
}
