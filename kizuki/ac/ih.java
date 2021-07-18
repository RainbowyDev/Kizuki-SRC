package kizuki.ac;

import kizuki.ac.check.*;
import kizuki.ac.packet.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.event.*;
import com.comphenix.protocol.*;
import com.google.common.collect.*;
import java.lang.reflect.*;
import org.bukkit.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import java.util.*;

public class ih
{
    public static volatile HashMap II;
    public static volatile int II;
    
    public ih() {
        final Iterator<Player> iterator;
        Player player;
        PacketContainer packetContainer;
        final short n;
        final Iterator<World> iterator2;
        World world;
        final Iterator<Entity> iterator3;
        Entity entity;
        ConcurrentLinkedQueue<Vector> concurrentLinkedQueue;
        new Thread(() -> {
            while (true) {
                try {
                    while (Checkable.thread.isAlive()) {
                        try {
                            Bukkit.getOnlinePlayers().iterator();
                            while (iterator.hasNext()) {
                                player = iterator.next();
                                PacketManager.II(new uf(player));
                                packetContainer = new PacketContainer(PacketType$Play$Server.TRANSACTION);
                                BukkitEventListener2.II(player.getUniqueId()).getTransactionId();
                                packetContainer.getIntegers().write(0, (Object)0);
                                packetContainer.getShorts().write(0, (Object)n);
                                packetContainer.getBooleans().write(0, (Object)false);
                                try {
                                    ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
                                    ((ArrayListMultimap)PacketManager.II.get(player)).put((Object)n, (Object)System.nanoTime());
                                }
                                catch (InvocationTargetException ex2) {}
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        ++ih.II;
                        Bukkit.getWorlds().iterator();
                        while (iterator2.hasNext()) {
                            world = iterator2.next();
                            if (world.getPlayers().size() < 1) {
                                continue;
                            }
                            else {
                                new ConcurrentLinkedQueue<Entity>(world.getEntities()).iterator();
                                while (iterator3.hasNext()) {
                                    entity = iterator3.next();
                                    if (!(entity instanceof LivingEntity) && !(entity instanceof Boat)) {
                                        continue;
                                    }
                                    else {
                                        concurrentLinkedQueue = ih.II.getOrDefault(entity.getUniqueId(), new ConcurrentLinkedQueue<Vector>());
                                        concurrentLinkedQueue.add(entity.getLocation().toVector());
                                        if (concurrentLinkedQueue.size() > 20) {
                                            concurrentLinkedQueue.remove();
                                        }
                                        ih.II.put(entity.getUniqueId(), concurrentLinkedQueue);
                                    }
                                }
                            }
                        }
                        Thread.sleep(50L);
                    }
                }
                catch (Exception ex3) {
                    ih.II = 0;
                    continue;
                }
                break;
            }
        }).start();
    }
    
    public static Vector[] II(final UUID uuid) {
        return ih.II.getOrDefault(uuid, new ConcurrentLinkedQueue()).toArray(new Vector[0]);
    }
    
    static {
        ih.II = new HashMap();
        ih.II = 0;
    }
}
