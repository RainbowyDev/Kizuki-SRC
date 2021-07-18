package kizuki.ac.bstats;

import org.bukkit.configuration.file.*;
import org.bukkit.*;
import kizuki.ac.api.*;
import org.json.simple.*;
import java.util.*;
import org.bukkit.entity.*;
import java.lang.reflect.*;
import org.bukkit.plugin.*;
import java.util.logging.*;
import javax.net.ssl.*;
import java.net.*;
import java.util.zip.*;
import java.io.*;

public class Metrics
{
    public static final int II = 1;
    private static final String II = "https://bStats.org/submitData/bukkit";
    private static boolean II;
    private static String iI;
    private final Plugin II;
    private final List II;
    
    public Metrics(final Plugin ii) {
        this.II = new ArrayList();
        if (ii == null) {
            throw new IllegalArgumentException("Plugin cannot be null!");
        }
        this.II = ii;
        final File file = new File(new File(ii.getDataFolder().getParentFile(), "bStats"), "config.yml");
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!loadConfiguration.isSet("serverUuid")) {
            loadConfiguration.addDefault("enabled", (Object)true);
            loadConfiguration.addDefault("serverUuid", (Object)UUID.randomUUID().toString());
            loadConfiguration.addDefault("logFailedRequests", (Object)false);
            loadConfiguration.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)").copyDefaults(true);
            try {
                loadConfiguration.save(file);
            }
            catch (IOException ex) {}
        }
        Metrics.iI = loadConfiguration.getString("serverUuid");
        Metrics.II = loadConfiguration.getBoolean("logFailedRequests", false);
        if (loadConfiguration.getBoolean("enabled", true)) {
            boolean b = false;
            for (final Class clazz : Bukkit.getServicesManager().getKnownServices()) {
                try {
                    clazz.getField("B_STATS_VERSION");
                    b = true;
                    System.out.println("ABCD");
                }
                catch (NoSuchFieldException ex2) {
                    continue;
                }
                break;
            }
            Bukkit.getServicesManager().register((Class)Metrics.class, (Object)this, ii, ServicePriority.Normal);
            if (!b) {
                System.out.println("ABC");
                this.II();
            }
        }
    }
    
    void II(final boolean ii) {
        Metrics.II = ii;
    }
    
    public void II(final AbstractChart abstractChart) {
        if (abstractChart == null) {
            throw new IllegalArgumentException("Chart cannot be null!");
        }
        this.II.add(abstractChart);
    }
    
    private void II() {
        final Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new BStatsTicker(this, timer), 300000L, 1800000L);
    }
    
    public JSONObject II() {
        final JSONObject jsonObject = new JSONObject();
        final String name = this.II.getDescription().getName();
        final String version = KizukiAntiCheatAPI.getVersion();
        jsonObject.put((Object)"pluginName", (Object)name);
        jsonObject.put((Object)"pluginVersion", (Object)version);
        final JSONArray jsonArray = new JSONArray();
        final Iterator<AbstractChart> iterator = (Iterator<AbstractChart>)this.II.iterator();
        while (iterator.hasNext()) {
            final JSONObject ii = iterator.next().iI();
            if (ii == null) {
                continue;
            }
            jsonArray.add((Object)ii);
        }
        jsonObject.put((Object)"customCharts", (Object)jsonArray);
        return jsonObject;
    }
    
    private JSONObject iI() {
        int size;
        try {
            final Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", (Class<?>[])new Class[0]);
            size = (method.getReturnType().equals(Collection.class) ? ((Collection)method.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[])method.invoke(Bukkit.getServer(), new Object[0])).length);
        }
        catch (Exception ex) {
            size = Bukkit.getOnlinePlayers().size();
        }
        final int onlineMode = Bukkit.getOnlineMode() ? 1 : 0;
        final String version = Bukkit.getVersion();
        final String substring = version.substring(version.indexOf("MC: ") + 4, version.length() - 1);
        final String property = System.getProperty("java.version");
        final String property2 = System.getProperty("os.name");
        final String property3 = System.getProperty("os.arch");
        final String property4 = System.getProperty("os.version");
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put((Object)"serverUUID", (Object)Metrics.iI);
        jsonObject.put((Object)"playerAmount", (Object)size);
        jsonObject.put((Object)"onlineMode", (Object)onlineMode);
        jsonObject.put((Object)"bukkitVersion", (Object)substring);
        jsonObject.put((Object)"javaVersion", (Object)property);
        jsonObject.put((Object)"osName", (Object)property2);
        jsonObject.put((Object)"osArch", (Object)property3);
        jsonObject.put((Object)"osVersion", (Object)property4);
        jsonObject.put((Object)"coreCount", (Object)availableProcessors);
        return jsonObject;
    }
    
    private void iI() {
        final JSONObject ii = this.iI();
        final JSONArray jsonArray = new JSONArray();
        for (final Class clazz : Bukkit.getServicesManager().getKnownServices()) {
            try {
                clazz.getField("B_STATS_VERSION");
                for (final RegisteredServiceProvider registeredServiceProvider : Bukkit.getServicesManager().getRegistrations((Class)clazz)) {
                    try {
                        jsonArray.add(registeredServiceProvider.getService().getMethod("getPluginData", (Class[])new Class[0]).invoke(registeredServiceProvider.getProvider(), new Object[0]));
                    }
                    catch (Throwable t) {}
                }
            }
            catch (Throwable t2) {}
        }
        ii.put((Object)"plugins", (Object)jsonArray);
        final JSONObject jsonObject;
        new Thread(() -> {
            try {
                II(jsonObject);
            }
            catch (Exception ex) {
                if (Metrics.II) {
                    this.II.getLogger().log(Level.WARNING, "Could not submit plugin stats of " + this.II.getName(), ex);
                }
            }
        }).start();
    }
    
    private static void II(final JSONObject jsonObject) {
        if (jsonObject == null) {
            throw new IllegalArgumentException("Data cannot be null!");
        }
        if (Bukkit.isPrimaryThread()) {
            throw new IllegalAccessException("This method must not be called from the main thread!");
        }
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL("https://bStats.org/submitData/bukkit").openConnection();
        final byte[] ii = II(jsonObject.toString());
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.addRequestProperty("Accept", "application/json");
        httpsURLConnection.addRequestProperty("Connection", "close");
        httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(ii.length));
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("User-Agent", "MC-Server/1");
        httpsURLConnection.setDoOutput(true);
        final DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.write(ii);
        dataOutputStream.flush();
        dataOutputStream.close();
        httpsURLConnection.getInputStream().close();
    }
    
    private static byte[] II(final String s) {
        if (s == null) {
            return null;
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gzipOutputStream.write(s.getBytes("UTF-8"));
        gzipOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
    
    static {
        if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
            final String s = new String(new byte[] { 111, 114, 103, 46, 98, 115, 116, 97, 116, 115, 46, 98, 117, 107, 107, 105, 116 });
            final String s2 = new String(new byte[] { 121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101 });
            if (Metrics.class.getPackage().getName().equals(s) || Metrics.class.getPackage().getName().equals(s2)) {
                throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
            }
        }
    }
}
