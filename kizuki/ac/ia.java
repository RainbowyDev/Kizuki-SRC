package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;
import java.util.*;

public class ia extends AbstractChart
{
    private final Callable II;
    
    public ia(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    @Override
    protected JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final JSONObject jsonObject2 = new JSONObject();
        final Map<Object, V> map = this.II.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            final JSONArray jsonArray = new JSONArray();
            jsonArray.add((Object)entry.getValue());
            jsonObject2.put(entry.getKey(), (Object)jsonArray);
        }
        jsonObject.put((Object)"values", (Object)jsonObject2);
        return jsonObject;
    }
}
