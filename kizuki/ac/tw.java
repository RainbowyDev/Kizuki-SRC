package kizuki.ac;

import org.bukkit.block.*;
import kizuki.ac.utils.*;
import org.bukkit.enchantments.*;
import org.bukkit.potion.*;
import kizuki.ac.event.*;
import java.util.*;
import java.lang.reflect.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.*;
import java.util.regex.*;

public final class tw
{
    private static final Pattern II;
    public static final String II;
    static final /* synthetic */ boolean II;
    
    private tw() {
    }
    
    public static Class II(final String s) {
        final String string = "net.minecraft.server." + tw.II + s;
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static float II(final int n) {
        try {
            final Class ii = II("Block");
            if (!tw.II && ii == null) {
                throw new AssertionError();
            }
            final Object invoke = ii.getMethod("getById", Integer.TYPE).invoke(ii, n);
            return invoke.getClass().getField("frictionFactor").getFloat(invoke);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1.0f;
        }
    }
    
    public static float iI(final int n) {
        try {
            final Class ii = II("Block");
            if (!tw.II && ii == null) {
                throw new AssertionError();
            }
            final Object invoke = ii.getMethod("getById", Integer.TYPE).invoke(ii, n);
            return invoke.getClass().getField("frictionFactor").getFloat(invoke);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1.0f;
        }
    }
    
    public static float Ii(final int n) {
        try {
            final Class ii = II("Block");
            if (!tw.II && ii == null) {
                throw new AssertionError();
            }
            final Object invoke = ii.getMethod("getById", Integer.TYPE).invoke(ii, n);
            return invoke.getClass().getField("frictionFactor").getFloat(invoke);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1.0f;
        }
    }
    
    public static float II(final Block block, final Player player, final int n) {
        if (block == null || !BlockUtils.Ii(block.getLocation())) {
            return 0.0f;
        }
        final float ii = iI(n);
        return (ii < 0.0f) ? 0.0f : (iI(block, player) ? (II(block, true, player) / ii / 30.0f) : (II(block, false, player) / ii / 100.0f));
    }
    
    private static boolean iI(final Block block, final Player player) {
        boolean booleanValue = false;
        try {
            final Object ii = II(block.getType().getId());
            final Object invoke = ii.getClass().getMethod("getMaterial", (Class<?>[])new Class[0]).invoke(ii, new Object[0]);
            booleanValue = (boolean)invoke.getClass().getMethod("isAlwaysDestroyable", (Class<?>[])new Class[0]).invoke(invoke, new Object[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return booleanValue || II(block, player);
    }
    
    private static float II(final Block block, final boolean b, final Player player) {
        float ii = II(block, player);
        if (ii > 1.0f && iI(player) != null) {
            final int enchantmentLevel = player.getItemInHand().getEnchantmentLevel(Enchantment.DIG_SPEED);
            if (enchantmentLevel > 0) {
                final float n = (float)(enchantmentLevel * enchantmentLevel + 1);
                if (!II(block, player) && ii <= 1.0f) {
                    ii += n * 0.08f;
                }
                else {
                    ii += n;
                }
            }
        }
        for (final PotionEffect potionEffect : player.getPlayer().getActivePotionEffects()) {
            if (potionEffect.getType().equals((Object)PotionEffectType.FAST_DIGGING)) {
                ii *= 1.0f + (potionEffect.getAmplifier() + 1) * 0.2f;
            }
            if (BukkitEventListener2.II().II() >= 47) {
                if (!potionEffect.getType().equals((Object)PotionEffectType.SLOW_DIGGING)) {
                    continue;
                }
                float n2 = 0.0f;
                switch (potionEffect.getAmplifier()) {
                    case 0: {
                        n2 = 0.3f;
                        break;
                    }
                    case 1: {
                        n2 = 0.09f;
                        break;
                    }
                    case 2: {
                        n2 = 0.0027f;
                        break;
                    }
                    default: {
                        n2 = 8.1E-4f;
                        break;
                    }
                }
                ii *= n2;
            }
            else {
                if (!potionEffect.getType().equals((Object)PotionEffectType.SLOW_DIGGING)) {
                    continue;
                }
                ii *= 1.0f - (potionEffect.getAmplifier() + 1) * 0.2f;
            }
        }
        return ii;
    }
    
    public static Object II(final Player player) {
        try {
            return player.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(player, new Object[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Object iI(final Player player) {
        try {
            final Object ii = II(player);
            if (!tw.II && ii == null) {
                throw new AssertionError();
            }
            return ii.getClass().getMethod("getHeldItem", (Class<?>[])new Class[0]).invoke(ii, new Object[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Object II(final int n) {
        try {
            final Class ii = II("Block");
            if (!tw.II && ii == null) {
                throw new AssertionError();
            }
            return ii.getClass().getMethod("getById", Integer.TYPE).invoke(ii.getClass(), n);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static boolean II(final Block block, final Player player) {
        try {
            final Object ii = iI(player);
            if (ii == null) {
                return false;
            }
            final Class ii2 = II("Block");
            if (!tw.II && ii2 == null) {
                throw new AssertionError();
            }
            return (boolean)ii.getClass().getMethod("b", ii2.getClass()).invoke(ii, Objects.requireNonNull(II(block.getType().getId())).getClass());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static float II(final Block block, final Player player) {
        try {
            final Object ii = iI(player);
            if (ii == null) {
                return 1.0f;
            }
            final Class ii2 = II("Block");
            if (!tw.II && ii2 == null) {
                throw new AssertionError();
            }
            final Method method = ii.getClass().getMethod("a", ii2.getClass());
            final Class ii3 = II("Block");
            return (float)method.invoke(ii, ii3.getMethod("getById", Integer.TYPE).invoke(ii3, block.getType().getId()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1.0f;
        }
    }
    
    public static Field II(final Class clazz, final String s) {
        try {
            final Field field = clazz.getField(s);
            field.setAccessible(true);
            return field;
        }
        catch (NoSuchFieldException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Object II(final Field field, final Object o) {
        try {
            field.setAccessible(true);
            return field.get(o);
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static Object II(final Method method, final Object o, final Object... array) {
        try {
            method.setAccessible(true);
            return method.invoke(o, array);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static Method II(final Class clazz, final String s, final Class... array) {
        try {
            final Method method = clazz.getMethod(s, (Class[])array);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static uv II(final Entity entity) {
        try {
            final Object invoke = entity.getClass().getMethod("getHandle", (Class<?>[])new Class[0]).invoke(entity, new Object[0]);
            final Object invoke2 = invoke.getClass().getMethod("getBoundingBox", (Class<?>[])new Class[0]).invoke(invoke, new Object[0]);
            final Class<?> class1 = invoke2.getClass();
            return new uv(class1.getField("a").getDouble(invoke2), class1.getField("b").getDouble(invoke2), class1.getField("c").getDouble(invoke2), class1.getField("d").getDouble(invoke2), class1.getField("e").getDouble(invoke2), class1.getField("f").getDouble(invoke2));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private boolean II(final Player player) {
        final Vector vector = player.getLocation().toVector();
        final double n = vector.getY() + 1.62;
        final int ii = this.II(vector.getX());
        final int n2 = (int)this.II((double)(float)this.II(n));
        final Block block = BlockUtils.getBlock(new Location(player.getWorld(), (double)ii, (double)n2, (double)this.II(vector.getZ())));
        return block != null && (block.getType() == Material.WATER || BlockUtils.isLiquid(block)) && n < n2 + 1 - (this.ii(block.getData()) - 0.11111111f);
    }
    
    private int II(final double n) {
        final int n2 = (int)n;
        return (n < n2) ? (n2 - 1) : n2;
    }
    
    private long II(final double n) {
        final long n2 = (long)n;
        return (n < n2) ? (n2 - 1L) : n2;
    }
    
    private float ii(int n) {
        if (n >= 8) {
            n = 0;
        }
        return (n + 1) / 9.0f;
    }
    
    static {
        II = !tw.class.desiredAssertionStatus();
        II = Pattern.compile(".", 16);
        II = tw.II.matcher(Bukkit.getServer().getClass().getPackage().getName()).replaceAll(Matcher.quoteReplacement(",")).split(",")[3] + ".";
    }
}
