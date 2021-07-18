package kizuki.ac.bstats;

import java.util.*;
import org.bukkit.*;

class BStatsTicker extends TimerTask
{
    final /* synthetic */ Timer II;
    final /* synthetic */ Metrics II;
    
    BStatsTicker(final Metrics ii, final Timer ii2) {
        this.II = ii;
        this.II = ii2;
    }
    
    @Override
    public void run() {
        if (!this.II.II.isEnabled()) {
            this.II.cancel();
            return;
        }
        Bukkit.getScheduler().runTask(this.II.II, (Runnable)new BStatsRunnable(this));
    }
}
