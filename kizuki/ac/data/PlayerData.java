package kizuki.ac.data;

import kizuki.ac.check.*;
import java.util.concurrent.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.check.impl.aim.*;
import kizuki.ac.check.impl.analysis.*;
import kizuki.ac.check.impl.hitbox.*;
import kizuki.ac.check.impl.aura.*;
import kizuki.ac.check.impl.autoclicker.*;
import kizuki.ac.check.impl.velocity.*;
import kizuki.ac.echeck.impl.packet.*;
import kizuki.ac.check.impl.packet.*;
import kizuki.ac.check.impl.timer.*;
import kizuki.ac.check.impl.motion.*;
import kizuki.ac.check.impl.flight.*;
import kizuki.ac.check.impl.speed.*;
import kizuki.ac.check.impl.jesus.*;
import kizuki.ac.check.impl.move.*;
import kizuki.ac.check.impl.scaffold.*;
import kizuki.ac.check.impl.inventory.*;
import kizuki.ac.check.impl.fastclimb.*;
import kizuki.ac.check.impl.hand.*;
import kizuki.ac.check.impl.phase.*;
import org.bukkit.util.*;
import kizuki.ac.utils.block.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import kizuki.ac.packet.*;
import org.bukkit.*;
import java.util.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;
import org.bukkit.potion.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;
import org.bukkit.inventory.*;

public class PlayerData
{
    public final KizukiCheck[] checks;
    final OfflinePlayer player;
    private final ConcurrentLinkedQueue lastVelocityMS;
    public ConcurrentLinkedQueue velocity;
    public boolean II;
    public long II;
    public boolean iI;
    public String II;
    public int II;
    public int iI;
    public boolean Ii;
    public long time;
    public version II;
    public boolean ii;
    public int Ii;
    public int ii;
    public int ll;
    public int sprinting;
    public int sneaking;
    public int groundTicks;
    public int sinceSprintTicks;
    public int sinceBoundingBoxFull;
    public int sinceIceTicks;
    public int sinceSlimeOrBedTicks;
    public int sinceHalfBlockTicks;
    public int sinceVehicleTicks;
    public int sinceLiquidTicks;
    public int sinceClimbableTicks;
    public int sinceBoundingBoxEmpty;
    public boolean ll;
    public VelocitySnapshot II;
    public long Ii;
    public long ii;
    public long ll;
    public float II;
    public boolean sprinting;
    public boolean sneaking;
    public LocationUtil II;
    public double II;
    public ArrayList II;
    public float iI;
    public float Ii;
    public int qp;
    public int hitTicks;
    public long lI;
    public boolean LL;
    public double iI;
    short II;
    EvictingList II;
    long Il;
    ConcurrentLinkedQueue iI;
    boolean qq;
    boolean qw;
    boolean qe;
    int qs;
    
    public PlayerData(final OfflinePlayer player) {
        this.checks = new KizukiCheck[] { new AimA(this), new AimB(this), new AimC(this), new AimD(this), new AimE(this), new AimF(this), new AimG(this), new AnalysisA(this), new AnalysisB(this), new HitboxAB(this), new KillAuraA(this), new KillAuraB(this), new KillAuraC(this), new KillAuraD(this), new KillAuraE(this), (KizukiCheck)new AutoclickerA(this), new AutoclickerB(this), new AutoclickerC(this), new VelocityA(this), new VelocityB(this), new VelocityC(this), new PacketA(this), new PacketB(this), new PacketC(this), new PacketD(this), new PacketE(this), new PacketF(this), new PacketG(this), new TimerA(this), new TimerB(this), new MotionA(this), new MotionB(this), new FlightA(this), new FlightB(this), new FlightC(this), new SpeedA(this), new SpeedB(this), new SpeedC(this), new JesusA(this), new JesusB(this), new JesusC(this), new MoveB(this), new MoveA(this), new ScaffoldA(this), new ScaffoldB(this), new ScaffoldC(this), new ScaffoldD(this), new ScaffoldE(this), new InventoryA(this), new FastClimbA(this), new HandA(this), new HandB(this), new PhaseA(this) };
        this.II = -1L;
        this.iI = false;
        this.II = "";
        this.iI = 0;
        this.time = System.currentTimeMillis();
        this.ii = 0;
        this.ll = 0;
        this.sprinting = 0;
        this.sneaking = 0;
        this.groundTicks = 0;
        this.sinceSprintTicks = 0;
        this.sinceBoundingBoxFull = 0;
        this.sinceIceTicks = 0;
        this.sinceSlimeOrBedTicks = 0;
        this.sinceHalfBlockTicks = 0;
        this.sinceVehicleTicks = 0;
        this.sinceLiquidTicks = 0;
        this.sinceClimbableTicks = 16;
        this.sinceBoundingBoxEmpty = 0;
        this.ll = false;
        this.II = null;
        this.Ii = -1L;
        this.ii = -1L;
        this.ll = 0L;
        this.II = 0.0f;
        this.sprinting = false;
        this.sneaking = false;
        this.II = null;
        this.II = 0.0;
        this.II = new ArrayList();
        this.iI = 0.0f;
        this.Ii = 0.0f;
        this.qp = 0;
        this.hitTicks = 10;
        this.lI = this.ll;
        this.LL = false;
        this.iI = this.currentTimeMillis();
        this.II = -32768;
        this.II = new EvictingList(20, true);
        this.Il = (long)this.currentTimeMillis();
        this.iI = new ConcurrentLinkedQueue();
        this.qq = false;
        this.qw = false;
        this.qe = false;
        this.qs = 0;
        this.II = config.II("alertTurnedOnByDefault");
        this.player = player;
        try {
            this.Ii = (player.getPlayer() != null && player.getPlayer().getUniqueId().getMostSignificantBits() == 0L);
        }
        catch (Exception ex) {
            this.Ii = false;
        }
        try {
            this.II = VersionUtil.getClientVersion(this.getPlayer());
        }
        catch (Exception ex2) {
            this.II = version.iI;
        }
        this.lastVelocityMS = new ConcurrentLinkedQueue();
        this.velocity = new ConcurrentLinkedQueue();
        for (int i = 0; i < 17; ++i) {
            this.lastVelocityMS.add(0.0f);
        }
        try {
            this.ll = this.getPlayer().isFlying();
        }
        catch (Exception ex3) {
            this.ll = false;
        }
    }
    
    public void II(final Vector vector) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    this.sendBlockUpdate(vector.clone().add(new Vector(i, j, k)));
                }
            }
        }
    }
    
    public void sendBlockUpdate(final Vector vector) {
        try {
            for (final KizukiBlock kizukiBlock : new ConcurrentLinkedQueue<KizukiBlock>(this.velocity)) {
                if (kizukiBlock.isEquals(vector)) {
                    this.velocity.remove(kizukiBlock);
                    break;
                }
            }
            final PacketContainer packetContainer = new PacketContainer(PacketType$Play$Server.BLOCK_CHANGE);
            packetContainer.getBlockPositionModifier().write(0, (Object)new BlockPosition(vector));
            packetContainer.getBlockData().write(0, (Object)WrappedBlockData.createData(BlockUtils.getBlock(vector.toLocation(this.getPlayer().getWorld())).getType()));
        }
        catch (Exception ex) {}
    }
    
    public boolean hasGivenVelocity(final Vector vector) {
        return this.velocity.stream().anyMatch(kizukiBlock -> kizukiBlock.isEquals(vector));
    }
    
    public boolean hasGivenVelocity(final Vector vector) {
        return this.velocity.stream().anyMatch(kizukiBlock -> kizukiBlock.II(vector));
    }
    
    public double getEyeHeight() {
        float n = 1.62f;
        if (this.getPlayer().isSleeping()) {
            n = 0.2f;
        }
        if (this.sneaking) {
            n -= 0.08f;
        }
        return n;
    }
    
    public float II(final CPacketFlying cPacketFlying) {
        final boolean flying = this.getPlayer().isFlying();
        final boolean ground = cPacketFlying.isGround();
        if (cPacketFlying.getTo().isInLiquid() && !flying) {
            return 0.8f;
        }
        float n = 0.91f;
        if (ground) {
            final Block block = BlockUtils.getBlock(new Location(this.getPlayer().getWorld(), cPacketFlying.getFrom().getX(), cPacketFlying.getFrom().getY() - 1.0, cPacketFlying.getFrom().getZ()));
            if (block != null) {
                n *= tw.II(block.getType().getId());
            }
        }
        return n;
    }
    
    public Player getPlayer() {
        return (Player)this.player;
    }
    
    public int II() {
        return this.II;
    }
    
    public void II(final int ii) {
        this.II = ii;
    }
    
    public void II(final Packet packet) {
        if (this.iI) {
            this.II = this.II + packet.toString() + "\n";
        }
        try {
            this.handlePacket(packet);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        final double currentTimeMillis = this.currentTimeMillis();
        for (final KizukiCheck kizukiCheck : this.checks) {
            try {
                if (kizukiCheck.isEnabled() && (!this.Ii || kizukiCheck.Ii())) {
                    kizukiCheck.handle(packet);
                }
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        this.II = this.currentTimeMillis() - currentTimeMillis;
    }
    
    public void handlePacket(final Packet packet) {
        if (!(packet instanceof CPacketDig)) {
            if (packet instanceof CPacketBlockPlace) {
                this.qe = false;
            }
            else if (packet instanceof CPacketArmAnimation) {
                if (BlockUtils.isInAir(this.getPlayer()).getType() == Material.AIR) {
                    this.II.add((int)(this.currentTimeMillis() - this.Il));
                }
                if (this.II.isFull()) {
                    this.II = (float)(1000.0 / MathUtil.getAverage(this.II));
                }
                this.Il = (long)this.currentTimeMillis();
            }
            else if (packet instanceof CPacketAbilities) {
                if (this.getPlayer().getAllowFlight() || !((CPacketAbilities)packet).isGround()) {
                    this.ll = ((CPacketAbilities)packet).isGround();
                    this.lI = this.ll;
                }
            }
            else if (packet instanceof CPacketPotatoGood) {
                this.iI.add(new Vector(((CPacketPotatoGood)packet).getDeltaXZ(), ((CPacketPotatoGood)packet).getDeltaY(), ((CPacketPotatoGood)packet).getDeltaX()));
            }
            else if (packet instanceof CPacketFlying) {
                ++this.iI;
                ++this.qs;
                boolean qq = false;
                if (!this.iI.isEmpty()) {
                    final Iterator<Vector> iterator = (Iterator<Vector>)this.iI.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().distance(((CPacketFlying)packet).getTo().toLocation().toVector()) < 0.001) {
                            qq = true;
                            this.iI.poll();
                            this.qs = 0;
                            break;
                        }
                    }
                }
                this.qw = this.qq;
                this.qq = qq;
                TaskUtils.runTask(() -> {
                    if (this.iI < 3 || this.iI()) {
                        this.getPlayer().setSprinting(false);
                        this.getPlayer().setFlying(false);
                    }
                    return;
                });
                final float deltaPitch = ((CPacketFlying)packet).getDeltaPitch();
                if (deltaPitch != 0.0f && Math.abs(deltaPitch) <= 11.0f && Math.abs(deltaPitch) > 0.01 && Math.abs(((CPacketFlying)packet).getTo().getPitch()) != 90.0f) {
                    this.lastVelocityMS.remove();
                    this.lastVelocityMS.add(Math.abs(deltaPitch));
                }
                if (this.lastVelocityMS.size() >= 17) {
                    this.iI = MathUtil.II(this.lastVelocityMS);
                    if (this.iI > 0.001) {
                        this.Ii = this.iI;
                    }
                }
                this.qp = (int)(MathUtil.II((float)((MathUtil.II((float)MathUtil.iI((float)(this.iI / 0.15 / 8.0), 3.0), 5).doubleValue() - 0.2) / 0.6), 5).doubleValue() * 200.0);
                ++this.ll;
                ++this.hitTicks;
                final CPacketFlying cPacketFlying = (CPacketFlying)packet;
                final LocationUtil to = cPacketFlying.getTo();
                final boolean ll = to.ll();
                final Collection ii = to.iI();
                final Collection collidedMaterials = BlockUtils.getCollidedMaterials(((CPacketFlying)packet).getTo(), 0.5, 0.5);
                final String lowerCase = ii.toString().toLowerCase();
                final String lowerCase2 = collidedMaterials.toString().toLowerCase();
                final boolean b = lowerCase.contains("slime") || lowerCase.contains("bed");
                final boolean contains = lowerCase.contains("ice");
                final boolean b2 = lowerCase.contains("stair") || lowerCase.contains("step");
                final boolean b3 = lowerCase2.contains("lava") || lowerCase2.contains("water");
                final boolean locationCollidingWithClimbable = BlockUtils.isLocationCollidingWithClimbable(((CPacketFlying)packet).getTo().toLocation());
                final String string = BlockUtils.getCollidedMaterials(cPacketFlying.getTo(), 3.0, 1.0, 3.0).toString();
                if (string.contains("PISTON_EXTENSION") || string.contains("PISTON_MOVING_PIECE")) {
                    this.ii = true;
                    this.Ii = 0;
                }
                else {
                    this.ii = false;
                    ++this.Ii;
                }
                if (!locationCollidingWithClimbable) {
                    ++this.sinceClimbableTicks;
                }
                else {
                    this.sinceClimbableTicks = 0;
                }
                if (!b3) {
                    ++this.sinceLiquidTicks;
                }
                else {
                    this.sinceLiquidTicks = 0;
                }
                if (!this.sprinting) {
                    ++this.sinceSprintTicks;
                }
                else {
                    this.sinceSprintTicks = 0;
                }
                if (!contains) {
                    ++this.sinceIceTicks;
                }
                else {
                    this.sinceIceTicks = 0;
                }
                if (!b) {
                    ++this.sinceSlimeOrBedTicks;
                }
                else {
                    this.sinceSlimeOrBedTicks = 0;
                }
                if (!b2) {
                    ++this.sinceHalfBlockTicks;
                }
                else {
                    this.sinceHalfBlockTicks = 0;
                }
                this.sinceVehicleTicks = (this.getPlayer().isInsideVehicle() ? 0 : (this.sinceVehicleTicks + 1));
                this.ii = (ll ? (this.ii + 1) : 0);
                this.ll = (ll ? 0 : (this.ll + 1));
                if (!cPacketFlying.isGround()) {
                    ++this.sneaking;
                    this.sprinting = this.sneaking;
                }
                else {
                    this.sneaking = 0;
                }
                this.groundTicks = (cPacketFlying.isGround() ? (this.groundTicks + 1) : 0);
                if (to.isBoundingBoxEmptyTall()) {
                    ++this.sinceBoundingBoxFull;
                    this.sinceBoundingBoxEmpty = 0;
                }
                else {
                    ++this.sinceBoundingBoxEmpty;
                    this.sinceBoundingBoxFull = 0;
                }
                if (ll) {
                    this.II = to;
                }
            }
            else if (packet instanceof SPacketEntityVelocity) {
                this.Ii = System.currentTimeMillis();
                this.II = ((SPacketEntityVelocity)packet).getVelocity();
                this.ii = this.ll;
            }
            else if (packet instanceof CPacketEntityAction) {
                final CPacketEntityAction cPacketEntityAction = (CPacketEntityAction)packet;
                if (cPacketEntityAction.getAction().equals((Object)EnumWrappers$PlayerAction.START_SPRINTING)) {
                    this.sprinting = true;
                }
                else if (cPacketEntityAction.getAction().equals((Object)EnumWrappers$PlayerAction.STOP_SPRINTING)) {
                    this.sprinting = false;
                }
                else if (cPacketEntityAction.getAction().equals((Object)EnumWrappers$PlayerAction.START_SNEAKING)) {
                    this.sneaking = true;
                }
                else if (cPacketEntityAction.getAction().equals((Object)EnumWrappers$PlayerAction.STOP_SNEAKING)) {
                    this.sneaking = false;
                }
            }
            else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK)) {
                this.hitTicks = 0;
            }
        }
    }
    
    public boolean II() {
        return this.ll || this.ll - this.lI < 3L;
    }
    
    public int iI() {
        return (int)(this.ll - this.ii);
    }
    
    public boolean iI() {
        return this.II(0);
    }
    
    public boolean II(final int n) {
        return this.qq || this.qw || this.qs <= n;
    }
    
    public boolean isBlocking() {
        return this.getPlayer().isBlocking() || this.qe;
    }
    
    public boolean II(final CPacketFlying cPacketFlying) {
        final int ii = this.iI();
        final int n = (150 + this.II()) / 50 + 1;
        final double deltaY = cPacketFlying.getDeltaY();
        boolean b = false;
        if (this.II != null) {
            b = (n > ii && (Math.abs(deltaY - this.II.getY()) < 5.0E-4 || (this.sneaking < 2 && Math.abs(deltaY - 0.42) < 1.0E-4)) && this.II.getY() > 0.0);
        }
        return b;
    }
    
    public boolean ii() {
        return (150 + this.II) / 50 >= (int)(this.ll - this.ii);
    }
    
    public boolean ll() {
        return this.iI(0);
    }
    
    public boolean iI(final int n) {
        return 175 + this.II + (n + this.Ii()) * 50L >= System.currentTimeMillis() - this.Ii;
    }
    
    public int II(final double n) {
        float n2 = (float)Math.abs(n);
        int n3 = 0;
        do {
            n2 = (float)((float)(n2 - 0.02) * 0.91);
            if (++n3 > 30) {
                break;
            }
        } while (n2 > -0.05);
        return n3;
    }
    
    public double II(final double n, final int n2) {
        if (n2 < 2) {
            return n;
        }
        float n3 = (float)Math.abs(n);
        int i = 0;
        do {
            n3 = (float)((float)(n3 - 0.02) * 0.91);
            if (++i > 30) {
                break;
            }
        } while (i != n2);
        return n3;
    }
    
    public int Ii() {
        if (this.II == null) {
            return 0;
        }
        return this.II(this.II.ii());
    }
    
    public double currentTimeMillis() {
        return System.nanoTime() / 1000000.0;
    }
    
    public boolean lI() {
        return this.LL;
    }
    
    public boolean Il() {
        return this.lI() || this.currentTimeMillis() - this.iI < 60.0;
    }
    
    public int getPotionLevel(final String s) {
        for (final PotionEffect potionEffect : this.getPlayer().getActivePotionEffects()) {
            if (potionEffect.getType().getName().equals(s)) {
                return potionEffect.getAmplifier() + 1;
            }
        }
        return 0;
    }
    
    public short getTransactionId() {
        if (this.II >= 32766) {
            this.II = -32768;
        }
        return (short)(++this.II);
    }
    
    public KizukiCheck getCheckByClass(final Class clazz) {
        for (final KizukiCheck kizukiCheck : this.checks) {
            if (kizukiCheck.getClass().getName().equals(clazz.getName())) {
                return kizukiCheck;
            }
        }
        return null;
    }
    
    public KizukiCheck iI(final Class clazz) {
        for (final KizukiCheck kizukiCheck : this.checks) {
            if (kizukiCheck.getClass().getName().equals(clazz.getName())) {
                return kizukiCheck;
            }
        }
        return null;
    }
    
    public KizukiCheck getCheckByName(final String s) {
        for (final KizukiCheck kizukiCheck : this.checks) {
            if (kizukiCheck.II().equalsIgnoreCase(s)) {
                return kizukiCheck;
            }
        }
        return null;
    }
    
    public KizukiCheck iI(final String s) {
        for (final KizukiCheck kizukiCheck : this.checks) {
            if (kizukiCheck.iI().equalsIgnoreCase(s)) {
                return kizukiCheck;
            }
        }
        return null;
    }
    
    public double getJumpMotion() {
        return 0.41999998688697815 + (this.getPlayer().hasPotionEffect(PotionEffectType.JUMP) ? (this.getPotionLevel("JUMP") * 0.1f) : 0.0);
    }
    
    public boolean isGlidingOrLevitating(final CPacketFlying cPacketFlying) {
        final ServerVersions ii = BukkitEventListener2.II();
        return !ii.equals(ServerVersions.iI) && !ii.equals(ServerVersions.II) && (this.getPlayer().isGliding() || this.getPotionLevel("LEVITATION") != 0);
    }
    
    public void shuffleHotbar() {
        if (this.getPlayer().hasPermission("kizuki.bypass")) {
            return;
        }
        final PlayerInventory inventory = this.getPlayer().getInventory();
        final int heldItemSlot = inventory.getHeldItemSlot();
        int heldItemSlot2;
        if (heldItemSlot == 0) {
            heldItemSlot2 = heldItemSlot + 1;
        }
        else {
            heldItemSlot2 = heldItemSlot - 1;
        }
        inventory.setHeldItemSlot(heldItemSlot2);
    }
}
