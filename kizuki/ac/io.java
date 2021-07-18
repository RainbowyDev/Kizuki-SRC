package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;
import java.util.*;

public class io extends AbstractChart
{
    private final Callable II;
    
    public io(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    public JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final JSONObject jsonObject2 = new JSONObject();
        final Map<Object, Map> map = this.II.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean b = true;
        for (final Map.Entry<Object, Map<Object, V>> entry : map.entrySet()) {
            final JSONObject jsonObject3 = new JSONObject();
            boolean b2 = true;
            for (final Map.Entry<Object, V> entry2 : map.get(entry.getKey()).entrySet()) {
                jsonObject3.put(entry2.getKey(), (Object)entry2.getValue());
                b2 = false;
            }
            if (!b2) {
                b = false;
                jsonObject2.put(entry.getKey(), (Object)jsonObject3);
            }
        }
        if (b) {
            return null;
        }
        jsonObject.put((Object)"values", (Object)jsonObject2);
        return jsonObject;
    }
}
