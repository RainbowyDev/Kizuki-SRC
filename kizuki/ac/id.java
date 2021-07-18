package kizuki.ac;

import kizuki.ac.bstats.*;
import java.util.concurrent.*;
import org.json.simple.*;

public class id extends AbstractChart
{
    private final Callable II;
    
    public id(final String s, final Callable ii) {
        super(s);
        this.II = ii;
    }
    
    @Override
    protected JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final int intValue = this.II.call();
        if (intValue == 0) {
            return null;
        }
        jsonObject.put((Object)"value", (Object)intValue);
        return jsonObject;
    }
}
