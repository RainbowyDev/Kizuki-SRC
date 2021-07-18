package kizuki.ac;

import kizuki.ac.check.enums.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import kizuki.ac.alert.*;
import kizuki.ac.utils.gui.*;
import java.util.concurrent.*;
import kizuki.ac.check.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import kizuki.ac.api.*;

public class rk
{
    static final /* synthetic */ boolean II;
    
    public static String II(final String s) {
        return tu.II("chestgui." + s);
    }
    
    public static boolean II(final String s) {
        return Boolean.parseBoolean(tu.II("chestgui." + s));
    }
    
    public static ArrayList II(final CheckType checkType) {
        final ArrayList<rm> list = new ArrayList<rm>();
        for (final rm rm : rn.II) {
            if (rm.II == checkType) {
                list.add(rm);
            }
        }
        return list;
    }
    
    public static ChestGUI II(final CheckType checkType) {
        try {
            final String lowerCase = checkType.Ii().toLowerCase();
            final String string = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
            final ArrayList ii = II(checkType);
            final int size = ii.size();
            final int n = (size - size % 8) / 8 + ((size % 8 > 0) ? 1 : 0);
            final ChestGUI chestGUI = new ChestGUI(n, II("checkswindowname").replace("%typename%", string) + " ");
            Material material;
            try {
                material = Material.getMaterial("STAINED_GLASS_PANE");
            }
            catch (Exception ex4) {
                material = Material.getMaterial("WHITE_STAINED_GLASS_PANE");
            }
            if (!rk.II && material == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack = new ItemStack(material);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(AlertFormatter.translateColorCodes(II("empty")));
            itemStack.setItemMeta(itemMeta);
            Il.II(chestGUI, 9, 54, itemStack);
            Material material2;
            try {
                material2 = Material.getMaterial("ARROW");
            }
            catch (Exception ex5) {
                material2 = Material.getMaterial("LEGACY_ARROW");
            }
            if (!rk.II && material2 == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack2 = new ItemStack(material2);
            final ItemMeta itemMeta2 = itemStack2.getItemMeta();
            if (!rk.II && itemMeta2 == null) {
                throw new AssertionError();
            }
            itemMeta2.setDisplayName(AlertFormatter.translateColorCodes(II("return")));
            itemStack2.setItemMeta(itemMeta2);
            chestGUI.II(n * 9, itemStack2, new rl(n * 9));
            try {
                final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue<rm>(ii);
                for (int i = 0; i < chestGUI.II() * 9; ++i) {
                    if ((i % 8 != 0 || i == 0) && !concurrentLinkedQueue.isEmpty()) {
                        final rm rm = concurrentLinkedQueue.poll();
                        final String s = II("uniquechecks") ? CheckType.II(rm.II()) : "PAPER";
                        final Material material3 = Material.getMaterial(s);
                        if (material3 == null) {
                            Material.getMaterial("LEGACY_" + s);
                        }
                        final ItemStack itemStack3 = new ItemStack(material3);
                        final ItemMeta itemMeta3 = itemStack3.getItemMeta();
                        final Set keys = Checkable.II().getConfigurationSection(CheckType.iI(rm.II) + "." + rm.II).getKeys(false);
                        final String ii2 = II("checklore");
                        String string2 = "";
                        for (final String s2 : keys) {
                            string2 += II("configvalue").replace("%key%", s2).replace("%value%", config.II(CheckType.iI(rm.II) + "." + rm.II + "." + s2));
                        }
                        final String replace = ii2.replace("%configvalues%", string2).replace("%desc%", CheckType.Ii(rm.II));
                        itemMeta3.setDisplayName(AlertFormatter.translateColorCodes(II("checkname").replace("%checkname%", rm.II)));
                        itemMeta3.setLore((List)Arrays.asList(AlertFormatter.translateColorCodes(replace).split("\n")));
                        itemStack3.setItemMeta(itemMeta3);
                        try {
                            chestGUI.II(i + 1);
                            chestGUI.II(i + 1, itemStack3);
                            chestGUI.Ii(new rz(i, rm));
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
            }
            return chestGUI;
        }
        catch (Exception ex3) {
            ex3.printStackTrace();
            return null;
        }
    }
    
    public static ChestGUI II() {
        try {
            final ChestGUI chestGUI = new ChestGUI(3, II("checktypewindowname") + " ");
            Material material;
            try {
                material = Material.getMaterial("STAINED_GLASS_PANE");
            }
            catch (Exception ex4) {
                material = Material.getMaterial("WHITE_STAINED_GLASS_PANE");
            }
            if (!rk.II && material == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack = new ItemStack(material);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(AlertFormatter.translateColorCodes(II("empty")));
            itemStack.setItemMeta(itemMeta);
            Il.II(chestGUI, 9, 27, itemStack);
            Il.II(chestGUI, 19, 27, itemStack);
            Material material2;
            try {
                material2 = Material.getMaterial("ARROW");
            }
            catch (Exception ex5) {
                material2 = Material.getMaterial("LEGACY_ARROW");
            }
            if (!rk.II && material2 == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack2 = new ItemStack(material2);
            final ItemMeta itemMeta2 = itemStack2.getItemMeta();
            if (!rk.II && itemMeta2 == null) {
                throw new AssertionError();
            }
            itemMeta2.setDisplayName(AlertFormatter.translateColorCodes(II("return")));
            itemStack2.setItemMeta(itemMeta2);
            chestGUI.II(27, itemStack2, new rx(27));
            try {
                final ConcurrentLinkedQueue<CheckType> concurrentLinkedQueue = new ConcurrentLinkedQueue<CheckType>(Arrays.asList(CheckType.values()));
                for (int i = 0; i < chestGUI.II() * 9; ++i) {
                    if ((i % 8 != 0 || i == 0) && !concurrentLinkedQueue.isEmpty()) {
                        final CheckType checkType = concurrentLinkedQueue.poll();
                        final String s = II("uniquetypes") ? CheckType.II(checkType) : "BOOK";
                        final Material material3 = Material.getMaterial(s);
                        if (material3 == null) {
                            Material.getMaterial("LEGACY_" + s);
                        }
                        final ItemStack itemStack3 = new ItemStack(material3);
                        final ItemMeta itemMeta3 = itemStack3.getItemMeta();
                        final String lowerCase = checkType.Ii().toLowerCase();
                        itemMeta3.setDisplayName(AlertFormatter.translateColorCodes(II("typename").replace("%typename%", lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1))));
                        itemMeta3.setLore((List)Arrays.asList(AlertFormatter.translateColorCodes(II("typelore")).split("\n")));
                        itemStack3.setItemMeta(itemMeta3);
                        try {
                            chestGUI.II(i + 1);
                            chestGUI.II(i + 1, itemStack3);
                            chestGUI.Ii(new rc(i, checkType));
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
            }
            return chestGUI;
        }
        catch (Exception ex3) {
            ex3.printStackTrace();
            return null;
        }
    }
    
    public static ChestGUI iI() {
        try {
            final ChestGUI chestGUI = new ChestGUI(3, II("startwindowname"));
            Material material;
            try {
                material = Material.getMaterial("STAINED_GLASS_PANE");
            }
            catch (Exception ex2) {
                material = Material.getMaterial("WHITE_STAINED_GLASS_PANE");
            }
            if (!rk.II && material == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack = new ItemStack(material);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(AlertFormatter.translateColorCodes(II("empty")));
            itemStack.setItemMeta(itemMeta);
            Il.II(chestGUI, 1, 27, itemStack);
            Il.II(chestGUI, 2, 26, new ItemStack(Material.AIR));
            final ItemStack itemStack2 = new ItemStack(Material.DIAMOND_SWORD);
            final ItemMeta itemMeta2 = itemStack2.getItemMeta();
            itemMeta2.setDisplayName(II("mainitemname").replace("%version%", KizukiAntiCheatAPI.getVersion()));
            itemMeta2.setLore((List)Arrays.asList(AlertFormatter.iI(II("mainitemlore")).split("\n")));
            itemStack2.setItemMeta(itemMeta2);
            chestGUI.II(2, 5, itemStack2);
            chestGUI.Ii(new rv(14));
            final ItemStack itemStack3 = new ItemStack(Material.EMERALD);
            final ItemMeta itemMeta3 = itemStack2.getItemMeta();
            itemMeta3.setDisplayName(II("reloaditemname"));
            itemMeta3.setLore((List)Arrays.asList(II("reloaditemlore").split("\n")));
            itemStack3.setItemMeta(itemMeta3);
            chestGUI.II(2, 7, itemStack3);
            chestGUI.Ii(new rj(2, 7));
            Material material2;
            try {
                material2 = Material.getMaterial("COMPASS");
            }
            catch (Exception ex3) {
                material2 = Material.getMaterial("LEGACY_COMPASS");
            }
            if (!rk.II && material2 == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack4 = new ItemStack(material2);
            final ItemMeta itemMeta4 = itemStack4.getItemMeta();
            if (!rk.II && itemMeta4 == null) {
                throw new AssertionError();
            }
            itemMeta4.setDisplayName(II("checksitemname"));
            itemMeta4.setLore((List)Arrays.asList(II("checksitemlore").split("\n")));
            itemStack4.setItemMeta(itemMeta4);
            chestGUI.II(2, 3, itemStack4);
            chestGUI.Ii(new rh(2, 3));
            Material material3;
            try {
                material3 = Material.getMaterial("BARRIER");
            }
            catch (Exception ex4) {
                material3 = Material.getMaterial("LEGACY_BARRIER");
            }
            if (!rk.II && material3 == null) {
                throw new AssertionError();
            }
            final ItemStack itemStack5 = new ItemStack(material3);
            final ItemMeta itemMeta5 = itemStack5.getItemMeta();
            if (!rk.II && itemMeta5 == null) {
                throw new AssertionError();
            }
            itemMeta5.setDisplayName(AlertFormatter.translateColorCodes(II("cancel")));
            itemStack5.setItemMeta(itemMeta5);
            chestGUI.II(27, itemStack5, new rb(26));
            return chestGUI;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    static {
        II = !rk.class.desiredAssertionStatus();
    }
}
