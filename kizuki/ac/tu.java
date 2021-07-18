package kizuki.ac;

import java.util.*;
import kizuki.ac.check.*;
import kizuki.ac.alert.*;

public class tu
{
    public static HashMap II;
    
    public static Object II(final String s) {
        String string = tu.II.getOrDefault(II() + "." + s, null);
        if (string == null) {
            string = Checkable.iI().getString(II() + "." + s);
            tu.II.put(II() + "." + s, string);
        }
        return string;
    }
    
    public static String II() {
        String string = tu.II.getOrDefault("style", null);
        if (string == null) {
            string = Checkable.iI().getString("style");
            tu.II.put("style", string);
        }
        return string;
    }
    
    public static Object iI(final String s) {
        return II(s);
    }
    
    public static String II(final String s) {
        return AlertFormatter.translateColorCodes((String)II(s));
    }
    
    static {
        tu.II = new HashMap();
    }
}
