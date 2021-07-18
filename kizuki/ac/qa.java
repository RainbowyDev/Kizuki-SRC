package kizuki.ac;

import java.util.concurrent.*;
import java.nio.charset.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class qa
{
    private final ConcurrentMap II;
    
    public qa() {
        this.II = new ConcurrentHashMap();
    }
    
    public void II(final String s, final String s2) {
        try {
            this.II.put(URLEncoder.encode(s, StandardCharsets.UTF_8.displayName()), URLEncoder.encode(s2, StandardCharsets.UTF_8.displayName()));
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public void II(final String s) {
        try {
            this.II.remove(URLEncoder.encode(s, StandardCharsets.UTF_8.displayName()));
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public String II() {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, V> entry : this.II.entrySet()) {
            sb.append(entry.getKey()).append("=").append((String)entry.getValue()).append("&");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
