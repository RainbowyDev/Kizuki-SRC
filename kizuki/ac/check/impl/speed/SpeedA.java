package kizuki.ac.check.impl.speed;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import java.util.*;
import kizuki.ac.packet.*;
import org.bukkit.potion.*;
import kizuki.ac.utils.*;
import org.bukkit.*;
import org.bukkit.util.*;
import com.comphenix.protocol.wrappers.*;
import org.bukkit.entity.*;
import kizuki.ac.packet.wrapper.*;

public class SpeedA extends KizukiCheck
{
    private final Map verbosePattern;
    boolean iI;
    boolean Ii;
    double verbosePattern;
    double iI;
    float verbosePattern;
    int verbosePattern;
    int iI;
    double Ii;
    int Ii;
    int ii;
    private int ll;
    private int lI;
    private CPacketFlying verbosePattern;
    
    public SpeedA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Speed (A)", "SpeedA", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = new HashMap();
        this.iI = false;
        this.Ii = false;
        this.verbosePattern = 0.0;
        this.iI = 0.0;
        this.verbosePattern = 0.0f;
        this.verbosePattern = 0;
        this.iI = 0;
        this.Ii = 0.0;
        this.Ii = 0;
        this.ii = 0;
        this.verbosePattern.put(2, 0.362);
        this.verbosePattern.put(3, 0.356);
        this.verbosePattern.put(4, 0.35);
        this.verbosePattern.put(5, 0.345);
        this.verbosePattern.put(6, 0.33575);
        this.verbosePattern.put(7, 0.331);
        this.verbosePattern.put(8, 0.329);
        this.verbosePattern.put(9, 0.325);
        this.verbosePattern.put(10, 0.32);
        this.verbosePattern.put(11, 0.315);
    }
    
    private double II(final int n) {
        return this.verbosePattern.getOrDefault(n, 0.36);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.verbosePattern != null) {
                this.verbosePattern = (CPacketFlying)packet;
                final int sneaking = this.getPlayerData().sneaking;
                final int groundTicks = this.getPlayerData().groundTicks;
                final int sinceIceTicks = this.getPlayerData().sinceIceTicks;
                final int sinceSlimeOrBedTicks = this.getPlayerData().sinceSlimeOrBedTicks;
                final boolean world = this.verbosePattern.getWorld();
                final boolean b = sneaking == 1;
                final boolean ii = this.getPlayerData().iI(6);
                final boolean b2 = groundTicks <= 2 || sneaking > 1;
                final String lowerCase = this.verbosePattern.getTo().iI().toString().toLowerCase();
                if ((this.getPlayerData().sinceHalfBlockTicks < 5 || lowerCase.contains("fence") || lowerCase.contains("wall")) && this.verbosePattern.getDeltaY() > 0.0 && this.verbosePattern.getDeltaY() % 0.015625 == 0.0) {
                    ++this.Ii;
                    this.ii = 0;
                }
                else {
                    ++this.ii;
                    this.Ii = 0;
                }
                final double deltaXZ = this.verbosePattern.getDeltaXZ();
                final double n = this.getPlayerData().getPlayer().getWalkSpeed() / 0.91;
                double ii2;
                if (b) {
                    ii2 = n * 2.2;
                }
                else if (b2) {
                    ii2 = this.II(sneaking);
                }
                else {
                    ii2 = Math.max(this.verbosePattern * 0.91, n) + 0.001;
                }
                this.verbosePattern = ii2;
                if (ii) {
                    ii2 += this.getPlayerData().II.ii() * 5.0;
                }
                if (this.getPlayerData().Ii < 20) {
                    ii2 += this.getPlayerData().II(1.0, this.getPlayerData().Ii);
                }
                if (this.ii < 15) {
                    this.debug("onStairs");
                    if (this.ii < 5) {
                        ii2 *= 1.7;
                        if (this.verbosePattern.getDeltaY() % 0.015625 == 0.0) {
                            ii2 *= 2.0;
                        }
                    }
                    else {
                        ii2 *= 1.5;
                    }
                }
                if (sinceIceTicks < 40 || sinceSlimeOrBedTicks < 40) {
                    if (this.getPlayerData().sinceBoundingBoxEmpty < 25) {
                        ii2 *= 2.5;
                    }
                    else {
                        ii2 *= 1.8;
                    }
                }
                double n2 = ii2 * (this.getPlayerData().getPlayer().hasPotionEffect(PotionEffectType.SPEED) ? (1.2 * this.getPlayerData().getPotionLevel("SPEED")) : 1.0);
                if (this.verbosePattern.isGround() || b) {
                    n2 *= ((this.getPlayerData().sprinting || this.getPlayerData().sinceSprintTicks < 2) ? 1.3 : 1.05);
                }
                if (this.getPlayerData().sneaking) {
                    ++this.verbosePattern;
                    if (this.verbosePattern > 15 && !this.getPlayerData().iI(5)) {
                        n2 *= 0.5;
                    }
                }
                else {
                    this.verbosePattern = 0;
                }
                if (this.verbosePattern.getTo().Ii()) {
                    ++this.iI;
                    if (this.iI > 6) {
                        n2 *= 0.3;
                    }
                }
                else {
                    this.iI = 0;
                }
                if (this.verbosePattern.isGround()) {
                    n2 += 0.0025;
                }
                if (this.getPlayerData().sinceBoundingBoxEmpty < 20) {
                    n2 *= 1.3;
                }
                try {
                    if (BlockUtils.isLiquid(BlockUtils.getBlock(this.verbosePattern.getTo().toLocation())) && Math.abs(this.verbosePattern.getDeltaY()) < 0.04 && this.getPlayerData().sneaking > 2 && !VersionUtil.isNewerThan1_12_2(this.getPlayerData().II)) {
                        n2 *= 0.6;
                    }
                }
                catch (Exception ex) {}
                if (VersionUtil.isNewerThan1_8(this.getPlayerData().II) && (world || this.iI)) {
                    n2 += 0.2;
                }
                double n3 = n2 + 0.0055;
                if (this.getPlayerData().isBlocking()) {
                    ++this.ll;
                    if (this.ll >= 10 && deltaXZ > n3 * 0.5) {
                        this.getPlayerData().shuffleHotbar();
                    }
                    if (this.ll > 13 & !this.getPlayerData().iI(5)) {
                        n3 *= 0.5;
                    }
                    this.lI = 0;
                }
                else {
                    ++this.lI;
                    if (this.lI > 2) {
                        this.ll = 0;
                    }
                }
                final boolean b3 = deltaXZ > n3 && this.getPlayerData().iI > 10 && !this.getPlayerData().getPlayer().getAllowFlight() && !this.getPlayerData().isGlidingOrLevitating(this.verbosePattern) && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && !this.getPlayerData().iI() && this.getPlayerData().sinceVehicleTicks > 3;
                this.debug(deltaXZ + "  " + n3 + " " + b3);
                if (b3) {
                    int n4 = 1;
                    if (Math.abs(deltaXZ - n3) < 0.015) {
                        this.Ii += deltaXZ - n3;
                        final float verbosePattern = this.verbosePattern;
                        this.verbosePattern = verbosePattern + 1.0f;
                        n4 = ((verbosePattern > 2.0f) ? 1 : 0);
                    }
                    else {
                        this.verbosePattern = 0.0f;
                    }
                    if (this.verbosePattern.isGround()) {
                        this.Ii = 0.0;
                    }
                    else if (this.Ii != 0.0) {
                        this.debug(this.Ii + "");
                        if (this.Ii > config.II(this.Ii() + ".quietAccFix")) {
                            this.flag("acc -> " + this.Ii);
                        }
                    }
                    if (n4 != 0) {
                        this.setback(new Vector((this.verbosePattern.getTo().getX() - this.verbosePattern.getFrom().getX()) * 2.0 - n3, (this.verbosePattern.getDeltaY() - 0.08) * 0.98, (this.verbosePattern.getTo().getZ() - this.verbosePattern.getFrom().getZ()) * 2.0 - n3), this.verbosePattern.getFrom());
                        this.flag("a -> " + this.getPlayerData().Ii + ", d -> " + (deltaXZ - n3) + "; b -> " + deltaXZ + "; c -> " + n3, (float)(1.0 + (deltaXZ - n3) * 2.0));
                        this.debug(n3 + " " + deltaXZ + " " + sneaking + " " + sinceIceTicks + " " + this.getPlayerData().sinceBoundingBoxEmpty);
                    }
                }
                this.iI = deltaXZ;
                this.Ii = false;
                this.iI = world;
            }
            this.verbosePattern = (CPacketFlying)packet;
        }
        else if (packet instanceof CPacketUseEntity) {
            if (((CPacketUseEntity)packet).getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK) && ((CPacketUseEntity)packet).getEntity() != null) {
                this.Ii = ((CPacketUseEntity)packet).getEntity().getType().equals((Object)EntityType.PLAYER);
            }
        }
        else if (packet instanceof CPacketDig) {
            this.debug("ev -> " + ((CPacketDig)packet).getDigType());
        }
    }
}
