package kizuki.ac.event;

import org.bukkit.entity.*;
import org.bukkit.util.*;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.*;
import kizuki.ac.utils.*;
import kizuki.ac.alert.*;
import kizuki.ac.data.*;
import java.util.function.*;
import java.util.stream.*;
import org.bukkit.command.*;
import kizuki.ac.check.*;
import net.md_5.bungee.api.chat.*;
import org.bukkit.*;
import kizuki.ac.*;
import kizuki.ac.api.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import kizuki.ac.packet.*;
import com.google.common.collect.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public final class BukkitEventListener2 implements Listener
{
    public static final Map II;
    public static final Map iI;
    public static boolean II;
    public static int II;
    
    public static void II(final Player player, final Vector vector) {
        try {
            final PacketContainer packetContainer = new PacketContainer(PacketType$Play$Server.ENTITY_VELOCITY);
            packetContainer.getModifier().writeDefaults();
            packetContainer.getIntegers().write(0, (Object)player.getEntityId());
            packetContainer.getIntegers().write(1, (Object)(int)(vector.getX() * 800.0));
            packetContainer.getIntegers().write(2, (Object)(int)(vector.getY() * 800.0));
            packetContainer.getIntegers().write(3, (Object)(int)(vector.getZ() * 800.0));
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void II(final Player player, final Location location) {
        try {
            final PacketContainer packetContainer = new PacketContainer(PacketType$Play$Server.POSITION);
            packetContainer.getModifier().writeDefaults();
            packetContainer.getDoubles().write(0, (Object)location.getX());
            packetContainer.getDoubles().write(1, (Object)location.getY());
            packetContainer.getDoubles().write(2, (Object)location.getZ());
            packetContainer.getFloat().write(0, (Object)location.getYaw());
            packetContainer.getFloat().write(1, (Object)location.getPitch());
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static ServerVersions II() {
        final String s = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return ServerVersions.valueOf(s);
        }
        catch (IllegalArgumentException ex) {
            Bukkit.getConsoleSender().sendMessage(AlertFormatter.translateColorCodes("&c ( + " + ex + " Unsupported version! (" + s + ")"));
            throw new IllegalArgumentException();
        }
    }
    
    public static void II(final KizukiACCheckAPI kizukiACCheckAPI, final Float n, final PlayerData playerData, final String s) {
        if (playerData.iI) {
            playerData.II = playerData.II + kizukiACCheckAPI.getChatName() + " " + s;
        }
        final KizukiCheck checkByName = playerData.getCheckByName(kizukiACCheckAPI.getChatName());
        checkByName.II().addValue(n);
        final TextComponent ii = AlertFormatter.II(playerData, checkByName, s, n);
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("kizuki.alerts")) {
                if (config.II("selfAlert") && !player.getName().equals(playerData.getPlayer().getName())) {
                    continue;
                }
                if (((PlayerData)BukkitEventListener2.II.get(player.getUniqueId())).II) {
                    player.spigot().sendMessage((BaseComponent)ii);
                }
                else {
                    if (!((PlayerData)BukkitEventListener2.II.get(player.getUniqueId())).II.contains(playerData.getPlayer().getName().toLowerCase())) {
                        continue;
                    }
                    player.spigot().sendMessage((BaseComponent)ii);
                }
            }
        }
        ++BukkitEventListener2.II;
        if (kizukiACCheckAPI.getVL().getValue() == checkByName.getBanVl()) {
            final UUID uuid;
            final KizukiCheck kizukiCheck;
            final String s2;
            final Iterator<String> iterator2;
            Bukkit.getScheduler().runTask(Checkable.plugin, () -> {
                playerData.getPlayer().getUniqueId();
                if (!BukkitEventListener2.iI.containsKey(uuid) || System.currentTimeMillis() - BukkitEventListener2.iI.get(uuid) >= config.II("punishmentIgnoreMs")) {
                    config.II("punishments." + kizukiCheck.ii());
                    Stream.of(s2.substring(1, s2.length() - 1).split(",")).map((Function<? super String, ?>)String::trim).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()).iterator();
                    while (iterator2.hasNext()) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), iterator2.next().replace("%prefix%", AlertFormatter.II()).replace("%player%", playerData.getPlayer().getName()).replace("%check%", kizukiCheck.II()));
                    }
                    kizukiCheck.II().setValue(kizukiCheck.II().getMin());
                    BukkitEventListener2.iI.put(playerData.getPlayer().getUniqueId(), System.currentTimeMillis());
                }
            });
        }
    }
    
    public static void II(final Packet packet) {
        try {
            II(packet.getPlayer().getUniqueId()).II(packet);
        }
        catch (NullPointerException ex2) {}
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static PlayerData II(final UUID uuid) {
        if (!BukkitEventListener2.II.containsKey(uuid)) {
            BukkitEventListener2.II.put(uuid, new PlayerData((OfflinePlayer)Bukkit.getPlayer(uuid)));
        }
        return BukkitEventListener2.II.get(uuid);
    }
    
    public static void II() {
        Checkable.iI.Ii();
        Checkable.II.Ii();
        config.II.clear();
        tu.II.clear();
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void II(final KizukiACSetBackEvent p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   kizuki/ac/api/KizukiACSetBackEvent.isCancelled:()Z
        //     4: ifeq            8
        //     7: return         
        //     8: new             Ljava/util/concurrent/atomic/AtomicInteger;
        //    11: dup            
        //    12: invokespecial   java/util/concurrent/atomic/AtomicInteger.<init>:()V
        //    15: astore_2       
        //    16: aload_2        
        //    17: aload_1        
        //    18: invokedynamic   BootstrapMethod #1, run:(Ljava/util/concurrent/atomic/AtomicInteger;Lkizuki/ac/api/KizukiACSetBackEvent;)Ljava/lang/Runnable;
        //    23: lconst_1       
        //    24: lconst_0       
        //    25: invokestatic    kizuki/ac/utils/TaskUtils.runTaskTimer:(Ljava/lang/Runnable;JJ)Lorg/bukkit/scheduler/BukkitTask;
        //    28: pop            
        //    29: return         
        //    StackMapTable: 00 01 08
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:264)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:198)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:276)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @EventHandler
    public void II(final PlayerJoinEvent playerJoinEvent) {
        final UUID uniqueId = playerJoinEvent.getPlayer().getUniqueId();
        PacketManager.II.put(playerJoinEvent.getPlayer(), ArrayListMultimap.create());
        BukkitEventListener2.II.put(uniqueId, new PlayerData((OfflinePlayer)playerJoinEvent.getPlayer()));
    }
    
    static {
        BukkitEventListener2.II = false;
        BukkitEventListener2.II = 0;
        II = new HashMap();
        iI = new HashMap();
    }
}
