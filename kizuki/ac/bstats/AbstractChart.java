package kizuki.ac.bstats;

import org.json.simple.*;
import org.bukkit.*;
import java.util.logging.*;

public abstract class AbstractChart
{
    final String II;
    
    AbstractChart(final String ii) {
        if (ii == null || ii.isEmpty()) {
            throw new IllegalArgumentException("ChartId cannot be null or empty!");
        }
        this.II = ii;
    }
    
    private JSONObject iI() {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put((Object)"chartId", (Object)this.II);
        try {
            final JSONObject ii = this.II();
            if (ii == null) {
                return null;
            }
            jsonObject.put((Object)"data", (Object)ii);
        }
        catch (Throwable t) {
            if (Metrics.II) {
                Bukkit.getLogger().log(Level.WARNING, "Failed to get data for custom chart with id " + this.II, t);
            }
            return null;
        }
        return jsonObject;
    }
    
    protected abstract JSONObject II();
}
