package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;
import java.util.*;

public class it extends AbstractChart
{
    private final Callable II;
    
    public it(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    @Override
    protected JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final JSONObject jsonObject2 = new JSONObject();
        final Map<K, int[]> map = this.II.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean b = true;
        for (final Map.Entry<K, int[]> entry : map.entrySet()) {
            if (entry.getValue().length == 0) {
                continue;
            }
            b = false;
            final JSONArray jsonArray = new JSONArray();
            final int[] array = entry.getValue();
            for (int length = array.length, i = 0; i < length; ++i) {
                jsonArray.add((Object)array[i]);
            }
            jsonObject2.put((Object)entry.getKey(), (Object)jsonArray);
        }
        if (b) {
            return null;
        }
        jsonObject.put((Object)"values", (Object)jsonObject2);
        return jsonObject;
    }
}
