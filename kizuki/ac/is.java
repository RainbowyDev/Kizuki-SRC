package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;

public class is extends AbstractChart
{
    private final Callable II;
    
    public is(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    @Override
    protected JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final String s = this.II.call();
        if (s == null || s.isEmpty()) {
            return null;
        }
        jsonObject.put((Object)"value", (Object)s);
        return jsonObject;
    }
}
