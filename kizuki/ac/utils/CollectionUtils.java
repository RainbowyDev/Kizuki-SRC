package kizuki.ac.utils;

import java.util.*;

public class CollectionUtils
{
    public static String concatanateStrings(final Collection collection) {
        String s = collection.toString() + " {";
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            s += iterator.next().toString();
        }
        return s;
    }
}
