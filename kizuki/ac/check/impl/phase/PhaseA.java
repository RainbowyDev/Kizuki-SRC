package kizuki.ac.check.impl.phase;

import kizuki.ac.check.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import java.util.stream.*;
import org.bukkit.*;
import org.bukkit.util.*;
import java.lang.reflect.*;
import org.bukkit.block.*;
import java.util.*;

public class PhaseA extends KizukiCheck
{
    private static final Set verbosePattern;
    float verbosePattern;
    private boolean iI;
    private boolean Ii;
    private LocationUtil verbosePattern;
    private CPacketFlying lastFlying;
    private int verbosePattern;
    
    public PhaseA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Phase (A)", "PhaseA", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = 0.0f;
        this.iI = false;
        this.Ii = true;
        this.verbosePattern = null;
    }
    
    public static boolean traverse(final Material material) {
        boolean b = false;
        final Iterator<String> iterator = PhaseA.verbosePattern.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().contains(material.toString().toUpperCase())) {
                b = true;
                break;
            }
        }
        return b || material.toString().toLowerCase().contains("anvil");
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.lastFlying != null) {
                final CPacketFlying lastFlying = this.lastFlying;
                final LocationUtil to = lastFlying.getTo();
                final double deltaXZ = lastFlying.getDeltaXZ();
                final double deltaY = lastFlying.getDeltaY();
                this.debug(lastFlying.getTo().iI() + "");
                if ((deltaXZ > 0.05 || Math.abs(deltaY) > 0.05) && BlockUtils.Ii(lastFlying.getTo().toLocation())) {
                    final List<? super Material> list = Arrays.stream(Material.values()).filter(Material::isBlock).filter(Material::isSolid).filter(Material::isOccluding).collect((Collector<? super Material, ?, List<? super Material>>)Collectors.toList());
                    final Collection ii = lastFlying.getTo().II();
                    final boolean ii2 = lastFlying.getTo().iI();
                    if (!ii2 && !this.Ii) {
                        this.Ii = true;
                    }
                    if (ii2 && this.getPlayerData().iI() && !this.iI) {
                        this.Ii = false;
                    }
                    if (!this.iI && ii2) {
                        this.verbosePattern = lastFlying.getFrom();
                    }
                    else if (!this.iI) {
                        this.verbosePattern = null;
                    }
                    if (ii2) {
                        boolean b = false;
                        final ArrayList<Material> list2 = new ArrayList<Material>();
                        for (final Object next : ii) {
                            final ArrayList<Double> list3 = new ArrayList<Double>();
                            for (final Field field : next.getClass().getFields()) {
                                try {
                                    list3.add(next.getClass().getField(field.getName()).getDouble(next));
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            final Block block = BlockUtils.getBlock(new Location(lastFlying.getWorld(), (double)list3.get(0), (double)list3.get(1), (double)list3.get(2)));
                            if (block == null) {
                                continue;
                            }
                            b = (b || !list.contains(block.getType()));
                            if (b) {
                                continue;
                            }
                            list2.add(block.getType());
                        }
                        this.debug(!b + " " + this.Ii);
                        boolean b2 = false;
                        final Iterator<Material> iterator2 = list2.iterator();
                        while (iterator2.hasNext()) {
                            if (traverse(iterator2.next())) {
                                this.debug("falling");
                                b2 = true;
                                break;
                            }
                        }
                        if (!b && !b2 && this.Ii && this.getBoolSetting("phased")) {
                            final float verbosePattern = this.verbosePattern;
                            this.verbosePattern = verbosePattern + 1.0f;
                            if (verbosePattern > 0.0f) {
                                this.flag("tried to phase into -> " + list2);
                                if (this.getBoolSetting("setback")) {
                                    this.setback(new Vector((lastFlying.getTo().getX() - lastFlying.getFrom().getX()) / -3.0, 0.0, (lastFlying.getTo().getZ() - lastFlying.getFrom().getZ()) / -3.0), lastFlying.getFrom());
                                }
                            }
                        }
                        else {
                            this.verbosePattern = 0.0f;
                        }
                        if (this.verbosePattern != null && b2 && this.Ii && this.getBoolSetting("walking")) {
                            if (this.verbosePattern++ > 1 && this.verbosePattern.toLocation().add(0.0, this.verbosePattern.getY() - to.getY(), 0.0).distance(to.toLocation()) > 2.0) {
                                this.flag("walking with phase in -> " + list2);
                                if (this.getBoolSetting("setback")) {
                                    this.setback(new Vector((lastFlying.getTo().getX() - lastFlying.getFrom().getX()) / -3.0, 0.0, (lastFlying.getTo().getZ() - lastFlying.getFrom().getZ()) / -3.0), lastFlying.getFrom());
                                }
                            }
                        }
                        else {
                            this.verbosePattern = 0;
                        }
                    }
                    this.iI = ii2;
                }
            }
            this.lastFlying = (CPacketFlying)packet;
        }
    }
    
    static {
        (verbosePattern = new TreeSet()).add("SAND");
        PhaseA.verbosePattern.add("GRAVEL");
    }
}
