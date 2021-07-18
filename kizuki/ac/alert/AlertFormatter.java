package kizuki.ac.alert;

import kizuki.ac.data.*;
import net.md_5.bungee.api.chat.*;
import java.util.*;
import kizuki.ac.event.*;
import kizuki.ac.utils.*;
import kizuki.ac.*;
import kizuki.ac.check.*;
import kizuki.ac.api.*;
import org.bukkit.*;

public final class AlertFormatter
{
    private AlertFormatter() {
    }
    
    public static TextComponent II(final PlayerData playerData, final KizukiCheck kizukiCheck, final String s, final float n) {
        final TextComponent textComponent = new TextComponent(II((String)tu.II("alerts"), playerData, kizukiCheck, s, n));
        textComponent.setHoverEvent(new HoverEvent(HoverEvent$Action.SHOW_TEXT, new ComponentBuilder(II((String)tu.II("alertinfo"), playerData, kizukiCheck, s, n)).create()));
        return textComponent;
    }
    
    public static String II(String s, final PlayerData playerData, final KizukiCheck kizukiCheck, final String s2, final float n) {
        s = ii(s);
        s = s.replace("%player%", Objects.requireNonNull(playerData.getPlayer().getName()));
        s = s.replace("%check%", kizukiCheck.II());
        if (s.contains("%bar%")) {
            s = s.replace("%bar%", II(kizukiCheck.getBanVl(), kizukiCheck.II().getValue()));
        }
        s = s.replace("%lcheck%", kizukiCheck.II().split(" ")[0]);
        s = s.replace("%letter%", kizukiCheck.II().split(" ")[1].replace("(", "").replace(")", ""));
        s = s.replace("%current_vl%", round(playerData.iI(kizukiCheck.getClass()).II().getValue(), getRoundPlaces()) + "");
        s = s.replace("%checktype%", kizukiCheck.getCheckType().getConfigLocation());
        s = s.replace("%ds%", kizukiCheck.getState().toString());
        s = s.replace("%vladd%", round(n, getRoundPlaces()) + "");
        s = s.replace("%maxvl%", round(n, getRoundPlaces()) + "");
        s = s.replace("%verbose%", s2.equals("") ? tu.II("noinfo") : s2);
        s = translateColorCodes(s);
        return s;
    }
    
    public static String II(final double n, final double n2) {
        final StringBuilder append = new StringBuilder(tu.II("bar.c1")).append(tu.II("bar.b1")).append(tu.II("bar.c2"));
        final int n3 = (int)(100.0 / (n / n2));
        final String ii = tu.II("bar.l1");
        for (int i = 0; i <= n3 / 3 - 1; ++i) {
            append.append(ii);
        }
        append.append(tu.II("bar.c3"));
        final String ii2 = tu.II("bar.l2");
        for (int j = 0; j <= (100 - n3) / 3 - 1; ++j) {
            append.append(ii2);
        }
        append.append(tu.II("bar.c4")).append(tu.II("bar.b2"));
        return append.toString();
    }
    
    public static int getRoundPlaces() {
        try {
            return Integer.parseInt(tu.II("roundVL"));
        }
        catch (Exception ex) {
            return 3;
        }
    }
    
    public static String II(final String s) {
        return translateColorCodes(tu.II("unknownCommand")).replace("%prefix%", II()).replace("%unknown_command%", s);
    }
    
    public static String iI(String s) {
        s = ii(s);
        s = s.replace("%server-version%", BukkitEventListener2.II().toString());
        s = s.replace("%protocol-version%", BukkitEventListener2.II().II() + "");
        s = s.replace("%viaversion%", VersionUtil.VIAVERSION_ENABLED + "");
        s = s.replace("%players%", Bukkit.getOnlinePlayers().size() + "");
        s = s.replace("%maxplayers%", Bukkit.getMaxPlayers() + "");
        s = s.replace("%timeforchecks%", ig.II() + "");
        s = s.replace("%tps%", (float)Checkable.II.II() + "");
        s = s.replace("%version%", KizukiAntiCheatAPI.getVersion());
        s = s.replace("%totalflags%", BukkitEventListener2.II + "");
        return translateColorCodes(s);
    }
    
    public static String translateColorCodes(final String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    
    public static String ii(final String s) {
        return s.replace("%prefix%", II());
    }
    
    public static String ll(final String s) {
        return (String)tu.II(s);
    }
    
    public static String II() {
        return translateColorCodes(ll("prefix"));
    }
    
    public static String lI(final String s) {
        return translateColorCodes((String)tu.II(s));
    }
    
    public static double round(final double n, final int n2) {
        if (n2 <= 0) {
            return (int)n;
        }
        final double pow = Math.pow(10.0, n2);
        return Math.round(n * pow) / pow;
    }
}
