package kizuki.ac.check.impl.aim;

import kizuki.ac.check.*;
import org.bukkit.entity.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.apache.commons.lang.*;
import org.bukkit.util.*;
import kizuki.ac.utils.*;
import org.bukkit.*;
import kizuki.ac.*;
import java.util.*;

public class AimE extends KizukiCheck
{
    float buffer;
    Entity lastEntity;
    EvictingList samples;
    private boolean lastFlag;
    
    public AimE(final PlayerData playerData) {
        super(playerData, CheckType.AIM, "AimAssist (E)", "AimE", DevelopmentState.EXPERIMENTAL, true);
        this.buffer = 0.0f;
        this.samples = new EvictingList(this.getIntSetting("size"), true);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketUseEntity) {
            this.lastEntity = ((CPacketUseEntity)packet).getEntity();
        }
        else if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final boolean boolSetting = this.getBoolSetting("aa");
            final boolean boolSetting2 = this.getBoolSetting("aareset");
            final int intSetting = this.getIntSetting("consistencypercent");
            final boolean boolSetting3 = this.getBoolSetting("ab");
            if (this.lastEntity != null) {
                if (((CPacketFlying)packet).getDeltaYaw() >= 5.0f || ((CPacketFlying)packet).getDeltaXZ() >= 0.3) {
                    final Vector[] ii = ih.II(this.lastEntity.getUniqueId());
                    if (ii.length < 20) {
                        return;
                    }
                    ArrayUtils.reverse((Object[])ii);
                    final Location location = ((CPacketFlying)packet).getFrom().toLocation();
                    boolean lastFlag = false;
                    final Vector vector = new Vector(location.getX(), this.getPlayerData().sneaking ? (location.getY() + 1.6 - 0.08) : (location.getY() + 1.6), location.getZ());
                    final Vector vectorForRotation = MathUtil.getVectorForRotation(location.getYaw(), location.getPitch());
                    final Ray ray = new Ray(vector, new Vector(vectorForRotation.getX(), vectorForRotation.getY(), vectorForRotation.getZ()));
                    int n = 0;
                    for (final Vector vector2 : ii) {
                        if (n - 1 < Math.ceil(this.getPlayerData().II() / 50.0)) {
                            ++n;
                        }
                        else {
                            if (n - 2 > Math.ceil(this.getPlayerData().II() / 50.0)) {
                                break;
                            }
                            ++n;
                            final uv ii2 = tw.II(this.lastEntity);
                            if (ii2 == null) {
                                return;
                            }
                            if (Math.abs(ii2.II - ii2.ii) > 0.65 || Math.abs(ii2.Ii - ii2.lI) > 0.65) {
                                return;
                            }
                            if (vector2 == null) {
                                return;
                            }
                            final Box box = new Box(ii2, vector2, 0.1);
                            if (box.isCollide(location.toVector())) {
                                break;
                            }
                            if (box.getIntercept(ray, 0.0f, Float.MAX_VALUE) != null) {
                                lastFlag = true;
                            }
                            if (box.getDistance(location.toVector()) > 1.1) {
                                if (!this.lastFlag && lastFlag && boolSetting3) {
                                    this.debug("a -> " + ((CPacketFlying)packet).getDeltaYaw() + ", prevl -> " + this.buffer);
                                    if (this.getPlayerData().hitTicks < 3) {
                                        if (((CPacketFlying)packet).getDeltaYaw() > 10.0f) {
                                            final float buffer = this.buffer;
                                            this.buffer = buffer + 1.0f;
                                            if (buffer > 2.0f) {}
                                        }
                                    }
                                    else {
                                        this.buffer = Math.max(0.0f, this.buffer - 0.025f);
                                    }
                                }
                                if (this.getPlayerData().hitTicks < 4) {
                                    this.samples.add(lastFlag);
                                    if (this.samples.isFull() && boolSetting) {
                                        double n2 = 0.0;
                                        final Iterator<Boolean> iterator = (Iterator<Boolean>)this.samples.iterator();
                                        while (iterator.hasNext()) {
                                            if (iterator.next()) {
                                                ++n2;
                                            }
                                        }
                                        this.debug(n2 / this.samples.size() * 100.0 + " " + intSetting + " " + lastFlag + " " + n2 + " " + this.samples.size());
                                        if (n2 / this.samples.size() * 100.0 >= intSetting && lastFlag) {
                                            this.flag("a/a a -> " + n2 / this.samples.size() * 100.0 + "% > " + intSetting + "%");
                                        }
                                        if (boolSetting2) {
                                            this.samples.clear();
                                        }
                                    }
                                }
                            }
                            this.lastFlag = lastFlag;
                        }
                    }
                }
            }
        }
    }
}
