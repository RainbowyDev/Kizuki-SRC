package kizuki.ac;

import kizuki.ac.utils.list.*;
import kizuki.ac.event.*;
import kizuki.ac.data.*;
import kizuki.ac.utils.*;
import java.util.*;

public class ig
{
    static EvictingList II;
    
    public static void II() {
        iI();
    }
    
    public static float II() {
        return ig.II.isEmpty() ? -1.0f : ((float)MathUtil.getAverage(ig.II));
    }
    
    static void iI() {
        final Iterator<PlayerData> iterator;
        double n = 0.0;
        TaskUtils.runTaskTimer(() -> {
            BukkitEventListener2.II.values().iterator();
            while (iterator.hasNext()) {
                n += iterator.next().II;
            }
            ig.II.add(n / BukkitEventListener2.II.values().size());
        }, 20L, 0L);
    }
    
    static {
        ig.II = new EvictingList(100, true);
    }
}
