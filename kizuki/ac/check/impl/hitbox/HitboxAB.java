package kizuki.ac.check.impl.hitbox;

import kizuki.ac.check.*;
import org.bukkit.entity.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.apache.commons.lang.*;
import java.util.*;
import kizuki.ac.utils.*;
import org.bukkit.util.*;
import org.bukkit.*;
import kizuki.ac.*;

public class HitboxAB extends KizukiCheck
{
    long verbosePattern;
    boolean iI;
    Entity verbosePattern;
    CPacketFlying verbosePattern;
    Location verbosePattern;
    float verbosePattern;
    
    public HitboxAB(final PlayerData playerData) {
        super(playerData, CheckType.HITBOX, "HitBox (AB)", "BasicAABB", DevelopmentState.TESTED, true);
        this.verbosePattern = this.getTime();
        this.verbosePattern = null;
        this.verbosePattern = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            this.verbosePattern = (CPacketFlying)packet;
            this.verbosePattern = ((CPacketFlying)packet).getTo().toLocation();
            if (this.iI) {
                this.Ii();
                this.iI = false;
            }
        }
        else if (packet instanceof CPacketUseEntity) {
            this.verbosePattern = ((CPacketUseEntity)packet).getEntity();
            this.iI = true;
            TaskUtils.runTaskLaterAsync(() -> {
                if (this.iI) {
                    this.Ii();
                    this.iI = false;
                }
            }, 1L);
        }
    }
    
    void Ii() {
        if (this.verbosePattern == null) {
            return;
        }
        final Vector[] ii = ih.II(this.verbosePattern.getUniqueId());
        if (ii.length < 20) {
            return;
        }
        ArrayUtils.reverse((Object[])ii);
        final Location[] array = { this.verbosePattern.getFrom().toLocation(), this.verbosePattern.getTo().toLocation() };
        double min = 99999.0;
        boolean b = false;
        final ArrayList<Double> list = new ArrayList<Double>();
        boolean b2 = false;
        int n = 1;
        for (final Location location : array) {
            final Vector vector = new Vector(location.getX(), this.getPlayerData().sneaking ? (location.getY() + 1.6 - 0.08) : (location.getY() + 1.6), location.getZ());
            final Vector vectorForRotation = MathUtil.getVectorForRotation(location.getYaw(), location.getPitch());
            final Ray ray = new Ray(vector, new Vector(vectorForRotation.getX(), vectorForRotation.getY(), vectorForRotation.getZ()));
            int n2 = 0;
            int n3 = 0;
            for (final Vector vector2 : ii) {
                if (n2 + 1 < Math.ceil(this.getPlayerData().II() / 50.0)) {
                    ++n2;
                    ++n3;
                }
                else {
                    if (n2 - 2 > Math.ceil(this.getPlayerData().II() / 50.0)) {
                        break;
                    }
                    ++n2;
                    final uv ii2 = tw.II(this.verbosePattern);
                    if (ii2 == null) {
                        return;
                    }
                    if (Math.abs(ii2.II - ii2.ii) < 0.2 || Math.abs(ii2.Ii - ii2.lI) < 0.2) {
                        return;
                    }
                    if (vector2 == null) {
                        return;
                    }
                    final Box box = new Box(ii2, vector2, 0.2);
                    if (box.isCollide(location.toVector())) {
                        min = 0.0;
                        b = true;
                        break;
                    }
                    if (box.getIntercept(ray, 0.0f, Float.MAX_VALUE) != null) {
                        b = true;
                    }
                    try {
                        boolean b3 = false;
                        if (config.II(this.Ii() + ".walls") && b) {
                            final Location location2 = location;
                            location2.setY(location2.getY() + 1.52);
                            final BlockIterator blockIterator = new BlockIterator(this.getPlayerData().getPlayer().getWorld(), vector, vectorForRotation, 0.0, (int)min + 1);
                            blockIterator.next();
                            while (blockIterator.hasNext()) {
                                if (!blockIterator.next().getType().isSolid()) {
                                    continue;
                                }
                                if (!box.isCollide(location.toVector())) {
                                    b3 = true;
                                    break;
                                }
                                break;
                            }
                        }
                        if (!b3 && n != 0) {
                            n = 0;
                        }
                    }
                    catch (Exception ex) {}
                    if (b) {
                        if (Math.abs(vector2.getY() - location.getY()) > 1.6) {
                            b2 = true;
                        }
                        final double n4 = box.getDistance(location.toVector()) + 0.13;
                        list.add(n4);
                        min = Math.min(min, n4);
                    }
                }
            }
        }
        if (min == 99999.0) {
            min = 0.0;
        }
        if (!this.getPlayerData().Il() && ih.II > 20 && this.verbosePattern.getDeltaYaw() < 20.0f && this.verbosePattern.getDeltaPitch() < 30.0f) {
            if (!b && config.II(this.Ii() + ".hitbox")) {
                final float verbosePattern = this.verbosePattern;
                this.verbosePattern = verbosePattern + 1.0f;
                if (verbosePattern > 1.0f) {
                    this.flag("t/h");
                }
                return;
            }
            this.verbosePattern = Math.max(this.verbosePattern - 0.25f, 0.0f);
            try {
                double ii3 = config.II(this.Ii() + ".allowedReach");
                double ii4 = config.II(this.Ii() + ".threshold");
                if (this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.CREATIVE)) {
                    ii3 += 2.0;
                    ii4 += 2.0;
                }
                if (b2) {
                    ++ii3;
                    ++ii4;
                }
                this.debug("lowest -> " + min + ", avg -> " + MathUtil.getAverage(list));
                if (n != 0 && config.II(this.Ii() + ".walls")) {
                    this.flag("walls");
                }
                if (min > ii3) {
                    if (min > ii4 || this.getTime() - this.verbosePattern < config.II(this.Ii() + ".time")) {
                        this.flag("t/r, r -> " + min + " / " + ii3 + ", t -> " + (this.verbosePattern - this.getTime()));
                    }
                    this.verbosePattern = this.getTime();
                    return;
                }
            }
            catch (Exception ex2) {
                this.debug("Iterable is empty");
            }
        }
        this.II().addValue(-0.0075f);
    }
}
