package kizuki.ac.check;

import java.util.concurrent.*;
import kizuki.ac.data.*;
import kizuki.ac.packet.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import java.lang.reflect.*;
import org.bukkit.util.*;
import org.bukkit.*;
import kizuki.ac.api.*;
import org.bukkit.event.*;
import kizuki.ac.utils.*;
import org.bukkit.entity.*;
import kizuki.ac.alert.*;
import java.util.regex.*;
import java.util.*;

public abstract class KizukiCheck extends Checkable
{
    private static final Pattern verbosePattern;
    final ConcurrentHashMap thread;
    private final PlayerData data;
    private final CheckType checkType;
    private final String iI;
    @Deprecated
    private final String Ii;
    private final DevelopmentState devState;
    private final boolean iI;
    public boolean thread;
    private LimitedDouble thread;
    
    public KizukiCheck(final PlayerData data, final CheckType checkType, final String ii, final String ii2, final DevelopmentState devState, final boolean ii3) {
        this.data = data;
        this.checkType = checkType;
        this.iI = ii;
        this.Ii = ii2;
        this.devState = devState;
        this.iI = ii3;
        this.thread = new ConcurrentHashMap();
        this.II((float)this.getBanVl());
    }
    
    public Packet pollAction(final short n) {
        return this.thread.remove(n);
    }
    
    public short confirmAction(final Packet packet) {
        final PacketContainer packetContainer = new PacketContainer(PacketType$Play$Server.TRANSACTION);
        final short transactionId = this.getPlayerData().getTransactionId();
        packetContainer.getIntegers().write(0, (Object)0);
        packetContainer.getShorts().write(0, (Object)transactionId);
        packetContainer.getBooleans().write(0, (Object)false);
        try {
            Checkable.protocolManager.sendServerPacket(this.getPlayerData().getPlayer(), packetContainer);
            this.thread.put(transactionId, packet);
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return transactionId;
    }
    
    public boolean getBoolSetting(final String s) {
        return config.II(this.Ii() + "." + s);
    }
    
    public double getDoubleSetting(final String s) {
        return config.II(this.Ii() + "." + s);
    }
    
    public String getStringSetting(final String s) {
        return config.II(this.Ii() + "." + s);
    }
    
    public int getIntSetting(final String s) {
        return config.II(this.Ii() + "." + s);
    }
    
    public KizukiACCheckAPI II() {
        return new KizukiACCheckAPI(this);
    }
    
    public void setback(final Vector vector, final LocationUtil locationUtil) {
        if (this.getPlayerData().getPlayer().hasPermission(KizukiAntiCheatAPI.getBypassPermission()) && !Checkable.II().getBoolean("bypassIgnore")) {
            return;
        }
        TaskUtils.runTask(() -> Bukkit.getServer().getPluginManager().callEvent((Event)new KizukiACSetBackEvent(this.getPlayerData().getPlayer(), vector, locationUtil.toLocation())));
    }
    
    public CheckType getCheckType() {
        return this.checkType;
    }
    
    public String II() {
        return this.iI;
    }
    
    public String iI() {
        return this.Ii;
    }
    
    public DevelopmentState getState() {
        return this.devState;
    }
    
    public LimitedDouble II() {
        return this.thread;
    }
    
    public void II(final LimitedDouble thread) {
        this.thread = thread;
    }
    
    public abstract void handle(final Packet p0);
    
    public void flag(final String s) {
        this.flag(s, 1.0f);
    }
    
    public void flag() {
        this.flag("", 1.0f);
    }
    
    public void flag(final String s, final float n) {
        KizukiAntiCheatAPI.flag(false, this.data.getPlayer(), this.II(), n, s);
    }
    
    public PlayerData getPlayerData() {
        return this.data;
    }
    
    public String Ii() {
        return this.checkType.getConfigLocation() + "." + this.Ii;
    }
    
    public String ii() {
        return config.II(this.Ii() + ".punishment");
    }
    
    public boolean II() {
        return this.thread;
    }
    
    public void II(final boolean thread) {
        this.thread = thread;
    }
    
    public void iI() {
        this.thread = !this.thread;
    }
    
    public void debug(final String s) {
        if (this.thread) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("kizuki.debug")) {
                    player.sendMessage(KizukiCheck.verbosePattern.matcher(AlertFormatter.translateColorCodes(AlertFormatter.lI("debug"))).replaceAll(Matcher.quoteReplacement(s)));
                }
            }
        }
    }
    
    public int getBanVl() {
        return Checkable.II().getInt(this.Ii() + ".banVL");
    }
    
    public void II(final float n) {
        this.thread = new LimitedDouble(0.0f, n, 0.0f);
    }
    
    public boolean isEnabled() {
        return config.II(this.Ii() + ".enabled");
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
    
    public boolean Ii() {
        return this.iI;
    }
    
    static {
        verbosePattern = Pattern.compile("%verbose%", 16);
    }
}
