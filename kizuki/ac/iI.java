package kizuki.ac;

import java.util.concurrent.*;
import kizuki.ac.utils.gui.*;
import java.util.*;

public class iI
{
    private static final ConcurrentLinkedDeque II;
    private static final ConcurrentHashMap II;
    
    public static void II(final String s, final ChestGUI chestGUI) {
        iI.II.put(s, chestGUI);
    }
    
    public static ChestGUI II(final String s) {
        for (final Map.Entry<String, V> entry : iI.II.entrySet()) {
            if (Il.translateColorCodes(entry.getKey()).equalsIgnoreCase(Il.translateColorCodes(s))) {
                return (ChestGUI)entry.getValue();
            }
        }
        return null;
    }
    
    public static void II(final ChestGUI chestGUI) {
        final String ii = chestGUI.II();
        final Iterator<String> iterator = iI.II.iterator();
        while (iterator.hasNext()) {
            if (Il.translateColorCodes(iterator.next()).equalsIgnoreCase(ii)) {
                return;
            }
        }
        iI.II.add(Il.translateColorCodes(ii.toLowerCase()));
        iI.II.put(Il.translateColorCodes(ii.toLowerCase()), chestGUI);
    }
    
    public static boolean II(final String s) {
        final Iterator<String> iterator = iI.II.iterator();
        while (iterator.hasNext()) {
            if (Il.translateColorCodes(iterator.next()).equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        II = new ConcurrentLinkedDeque();
        II = new ConcurrentHashMap();
    }
}
