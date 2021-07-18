package kizuki.ac.utils;

import org.bukkit.block.*;
import org.jetbrains.annotations.*;
import kizuki.ac.data.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import java.util.*;
import kizuki.ac.check.*;

public final class BlockUtils
{
    static HashMap II;
    
    public static boolean isClimbable(@NotNull final Block block) {
        return block.getType() == Material.VINE || block.getType() == Material.LADDER;
    }
    
    public static boolean isLiquid(@NotNull final Block block) {
        final String string;
        return (string = block.getType().toString()).contains("water") || string.contains("lava");
    }
    
    public static boolean isLocationWeb(final Location location) {
        return getCollidedMaterials(new LocationUtil(location), -1.0, 0.3).toString().toLowerCase().contains("web");
    }
    
    public static boolean isOnSlime(final PlayerData playerData) {
        if (playerData == null) {
            return false;
        }
        if (playerData.II == null) {
            return false;
        }
        final Location location = playerData.II.toLocation();
        if (location == null) {
            return false;
        }
        try {
            if (playerData.getPlayer().getLocation().clone().add(0.0, playerData.II.getY() - playerData.getPlayer().getLocation().getY(), 0.0).distance(playerData.II.toLocation()) > 4.0) {
                return false;
            }
        }
        catch (Exception ex) {
            return false;
        }
        for (double n = 0.3, n2 = -n; n2 <= n; n2 += n) {
            for (double n3 = -n; n3 <= n; n3 += n) {
                final Block block = getBlock(location.clone().add(n2, -0.5001, n3));
                final Block block2 = getBlock(location.clone().add(n2, -0.25001, n3));
                if (block != null) {
                    if (block2 != null) {
                        if (block.getType() == Material.SLIME_BLOCK || block2.getType() == Material.SLIME_BLOCK) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean isCollidingWith(final Location location, final Material material) {
        final double n = 0.3;
        for (double n2 = -1.0; n2 <= 3.0; ++n2) {
            for (double n3 = -n; n3 <= n; n3 += n) {
                for (double n4 = -n; n4 <= n; n4 += n) {
                    final Block block = getBlock(location.clone().add(n3, n2, n4));
                    if (block != null) {
                        if (block.getType() == material) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean isLocationCollidingWithClimbable(final Location location) {
        final double n = 0.3;
        for (double n2 = -1.0; n2 <= 1.0; ++n2) {
            for (double n3 = -n; n3 <= n; n3 += n) {
                for (double n4 = -n; n4 <= n; n4 += n) {
                    final Block block = getBlock(location.clone().add(n3, n2, n4));
                    if (block != null) {
                        if (isClimbable(block)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static Entity getEntityById(final World world, final int n) {
        for (final Entity entity : world.getEntities()) {
            if (entity.getEntityId() == n) {
                return entity;
            }
        }
        return null;
    }
    
    public static Block getBlock(final Location location) {
        if (location == null) {
            throw new NullPointerException("Location can't be null");
        }
        if (Objects.requireNonNull(location.getWorld()).isChunkLoaded(location.getBlockX() >> 4, location.getBlockZ() >> 4)) {
            return location.getBlock();
        }
        return null;
    }
    
    public static Block getBlock(final LocationUtil locationUtil) {
        if (locationUtil == null) {
            throw new NullPointerException("LocationUtil can't be null");
        }
        return getBlock(locationUtil.toLocation());
    }
    
    public static Block getBlock(final World world, final Vector vector) {
        if (world == null || vector == null) {
            throw new NullPointerException("Parameters can't be null! W -> " + world + ", V -> " + vector);
        }
        return getBlock(new Location(world, vector.getX(), vector.getY(), vector.getZ()));
    }
    
    public static Block isInAir(final Player player, final int n) {
        final BlockIterator blockIterator = new BlockIterator((LivingEntity)player, n);
        Block block = blockIterator.next();
        while (blockIterator.hasNext()) {
            block = blockIterator.next();
            if (block.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return block;
    }
    
    public static Block isInAir(final Player player) {
        return isInAir(player, 5);
    }
    
    public static Collection getCollidedMaterials(final LocationUtil locationUtil, final double n, final double n2) {
        return getCollidedMaterials(locationUtil, n, n2, 2.0);
    }
    
    public static Collection getCollidedMaterials(final LocationUtil locationUtil, final double n, final double n2, final double n3) {
        final ArrayList<Material> list = new ArrayList<Material>();
        try {
            for (int n4 = 0; n4 < n3; ++n4) {
                for (double n5 = -n; n5 <= n; n5 += n2) {
                    for (double n6 = -n; n6 <= n; n6 += n2) {
                        list.add(getBlock(locationUtil.toLocation().clone().add(n5, -0.5001 + n4, n6)).getType());
                        list.add(getBlock(locationUtil.toLocation().clone().add(n5, (double)(-1 + n4), n6)).getType());
                        list.add(getBlock(locationUtil.toLocation().clone().add(n5, -0.01 + n4, n6)).getType());
                    }
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    public static Collection getCollidedMaterials(final LocationUtil locationUtil) {
        final ArrayList<Material> list = new ArrayList<Material>();
        final double n = 0.3;
        try {
            for (double n2 = -n; n2 <= n; n2 += n) {
                for (double n3 = -n; n3 <= n; n3 += n) {
                    list.add(getBlock(locationUtil.toLocation().clone().add(n2, -0.5001, n3)).getType());
                    list.add(getBlock(locationUtil.toLocation().clone().add(n2, -1.0, n3)).getType());
                    list.add(getBlock(locationUtil.toLocation().clone().add(n2, -0.01, n3)).getType());
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    public static boolean Ii(@NotNull final Location location) {
        if (location.getWorld() == null) {
            return false;
        }
        final Vector vector = new Vector(location.getBlockX() >> 4, 0, location.getBlockZ() >> 4);
        final boolean chunkLoaded = location.getWorld().isChunkLoaded(location.getBlockX() >> 4, location.getBlockZ() >> 4);
        if (!chunkLoaded) {
            BlockUtils.II.put(vector, System.currentTimeMillis());
        }
        return (!BlockUtils.II.containsKey(vector) || System.currentTimeMillis() - BlockUtils.II.get(vector) >= 1000 + Checkable.II.II()) && chunkLoaded;
    }
    
    static {
        BlockUtils.II = new HashMap();
    }
}
