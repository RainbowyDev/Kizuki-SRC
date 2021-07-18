package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;
import java.util.*;

public class ip extends AbstractChart
{
    private final Callable II;
    
    public ip(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    @Override
    protected JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final JSONObject jsonObject2 = new JSONObject();
        final Map<K, Integer> map = this.II.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean b = true;
        for (final Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            b = false;
            jsonObject2.put((Object)entry.getKey(), (Object)entry.getValue());
        }
        if (b) {
            return null;
        }
        jsonObject.put((Object)"values", (Object)jsonObject2);
        return jsonObject;
    }
}
