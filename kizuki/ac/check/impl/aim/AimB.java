package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import kizuki.ac.utils.list.*;
import org.bukkit.entity.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.*;
import org.apache.commons.lang.*;
import org.bukkit.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.util.*;
import java.util.*;

public class AimB extends KizukiCheck
{
    EvictingList verbosePattern;
    EvictingList iI;
    EvictingList Ii;
    float verbosePattern;
    float iI;
    int verbosePattern;
    Entity verbosePattern;
    private float Ii;
    private float ii;
    
    public AimB(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (B)", "AimB", DevelopmentState.EXPERIMENTAL, true);
        this.verbosePattern = new EvictingList(20, true);
        this.iI = new EvictingList(100, true);
        this.Ii = new EvictingList(100, true);
        this.verbosePattern = 0.0f;
        this.iI = 0.0f;
        this.verbosePattern = 0;
        this.verbosePattern = null;
    }
    
    public static float fixYaw(float n) {
        n %= 360.0f;
        if (n >= 180.0f) {
            n -= 360.0f;
        }
        if (n < -180.0f) {
            n += 360.0f;
        }
        return n;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final float deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
            final float abs = Math.abs(((CPacketFlying)packet).getDeltaPitch());
            if (this.verbosePattern == null || this.getPlayerData().hitTicks > 5) {
                return;
            }
            if (this.verbosePattern.getVelocity().lengthSquared() < 0.05) {
                return;
            }
            final Vector[] ii = ih.II(this.verbosePattern.getUniqueId());
            if (ii.length < 20) {
                return;
            }
            ArrayUtils.reverse((Object[])ii);
            final Location[] array = { ((CPacketFlying)packet).getFrom().toLocation(), ((CPacketFlying)packet).getTo().toLocation() };
            boolean b = false;
            float ii2 = 999.0f;
            float verbosePattern = 999.0f;
            for (final Location location : array) {
                int n = 0;
                for (final Vector vector : ii) {
                    if (n + 1 < Math.ceil(this.getPlayerData().II() / 50.0)) {
                        ++n;
                    }
                    else {
                        if (n - 2 > Math.ceil(this.getPlayerData().II() / 50.0)) {
                            break;
                        }
                        ++n;
                        final float[] center = this.getCenter(vector.toLocation(this.getPlayerData().getPlayer().getWorld()), location);
                        final float abs2 = Math.abs(center[1] - location.getPitch());
                        final float abs3 = Math.abs(center[0] - location.getYaw());
                        if ((abs3 < 1.5 && abs2 < 1.5 && (abs > 2.0f || deltaYaw > 30.0f) && deltaYaw > 2.0f) || abs3 < 0.001 || abs2 < 0.001) {
                            b = true;
                        }
                        if (abs3 < ii2) {
                            ii2 = abs3;
                        }
                        if (abs2 < verbosePattern) {
                            verbosePattern = abs2;
                        }
                    }
                }
            }
            if (abs > 3.0f || deltaYaw > 6.0f) {
                this.verbosePattern.add(verbosePattern);
            }
            if (this.verbosePattern.isFull()) {
                this.debug("WTF");
                float n2 = -69.0f;
                final ArrayList<Float> list = new ArrayList<Float>();
                for (final float floatValue : this.verbosePattern) {
                    if (n2 != 69.0f) {
                        list.add(n2 - floatValue);
                    }
                    n2 = floatValue;
                }
                final float ii3 = (float)MathUtil.getAverage(list);
                this.debug("" + Math.abs(this.ii - ii3));
                if (Math.abs(this.ii - ii3) < 0.01) {
                    this.debug("a/c a -> " + ii3 + ", b -> " + this.ii);
                }
                this.ii = ii3;
                this.verbosePattern.clear();
            }
            if (ii2 < 20.0f && verbosePattern < 20.0f) {
                if (abs > 3.0f) {
                    this.iI.add(verbosePattern);
                }
                if (deltaYaw > 3.0f && Math.abs(deltaYaw - this.Ii) > 0.3) {
                    this.Ii.add(ii2);
                }
                final Object[] array4 = this.iI.toArray();
                Arrays.sort(array4);
                final Object[] array5 = this.Ii.toArray();
                Arrays.sort(array5);
                int n3 = 0;
                int n4 = 0;
                float n5 = 0.0f;
                boolean b2 = false;
                final Object[] array6 = array4;
                for (int length3 = array6.length, k = 0; k < length3; ++k) {
                    final float floatValue2 = (float)array6[k];
                    if (Math.abs(floatValue2 - n5) < 0.05) {
                        ++n3;
                    }
                    if (Math.abs(verbosePattern - n5) < 3.0f) {
                        b2 = true;
                    }
                    n5 = floatValue2;
                }
                if (n3 > 28 && b2) {
                    this.flag("a/a a -> " + n3);
                }
                if (this.II()) {
                    float n6 = 0.0f;
                    final Object[] array7 = array5;
                    for (int length4 = array7.length, l = 0; l < length4; ++l) {
                        final float floatValue3 = (float)array7[l];
                        if (Math.abs(floatValue3 - n6) < 0.0075) {
                            ++n4;
                        }
                        n6 = floatValue3;
                    }
                }
            }
            if ((b || (Math.abs(verbosePattern - this.verbosePattern) < 0.1 && deltaYaw > 4.0f) || (Math.abs(ii2 - this.iI) < 0.1 && Math.abs(abs) > 3.0f)) && verbosePattern < 20.0f && ii2 < 20.0f && this.verbosePattern.getLocation().distance(this.getPlayerData().getPlayer().getLocation()) > 1.0) {
                this.debug("flag");
                if (this.verbosePattern++ > 1) {
                    this.flag("a/b a -> " + verbosePattern + ", b -> " + ii2 + ", c -> " + this.verbosePattern + ", d -> " + this.iI);
                }
            }
            else {
                this.verbosePattern = 0;
            }
            this.iI = ii2;
            this.verbosePattern = verbosePattern;
            this.Ii = deltaYaw;
        }
        else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getEntity() != null) {
            this.verbosePattern = ((CPacketUseEntity)packet).getEntity();
        }
    }
    
    public float[] getCenter(final Location location, final Location location2) {
        final double n = location.getX() - location2.getX();
        final double n2 = location.getZ() - location2.getZ();
        return new float[] { location2.getYaw() + fixYaw((float)(Math.atan2(n2, n) * 180.0 / 3.141592653589793) - 90.0f - location2.getYaw()), location2.getPitch() + fixYaw((float)(-(Math.atan2(location.getY() + 1.53 - (location2.getY() + this.getPlayerData().getEyeHeight()), (float)Math.sqrt(n * n + n2 * n2)) * 180.0 / 3.141592653589793)) - location2.getPitch()) };
    }
}
