package kizuki.ac.utils.paste;

import org.jetbrains.annotations.*;
import org.xml.sax.*;
import java.io.*;
import javax.xml.parsers.*;
import kizuki.ac.*;
import java.util.*;

public class PasteModal implements LL
{
    public static final int II = 50;
    @NotNull
    private final String II;
    
    public PasteModal(@NotNull final String ii) {
        this.II = ii;
    }
    
    @NotNull
    @Override
    public qk II(@NotNull final qs qs) {
        return this.II(qs, null);
    }
    
    @NotNull
    @Override
    public qk II(@NotNull final qs qs, @Nullable final String s) {
        final Pastebin ii = Pastebin.II();
        ii.II("api_option", "paste");
        ii.II("api_dev_key", this.II);
        ii.II("api_paste_code", (String)qs.II().II());
        ii.II("api_paste_name", qs.iI());
        ii.II("api_paste_format", qs.ii());
        ii.II("api_paste_private", String.valueOf(qs.II().II()));
        ii.II("api_paste_expire_date", qs.II().II());
        if (s != null) {
            ii.II("api_user_key", s);
        }
        return ii.II();
    }
    
    @NotNull
    @Override
    public qk II() {
        final Pastebin ii = Pastebin.II();
        ii.II("api_option", "trends");
        ii.II("api_dev_key", this.II);
        final qk ii2 = ii.II();
        if (ii2.II()) {
            return ql.II(ii2.II());
        }
        try {
            return ql.II(qh.II("<root>" + (String)ii2.II() + "</root>"));
        }
        catch (SAXException | IOException | ParserConfigurationException ex) {
            return ql.II("Unable to prepare/parse the XML response");
        }
    }
    
    @NotNull
    @Override
    public qk II(final String s) {
        return qh.II(s);
    }
    
    @NotNull
    @Override
    public qk II(@NotNull final String s, @NotNull final String s2) {
        final Pastebin ii = Pastebin.Ii();
        ii.II("api_dev_key", this.II);
        ii.II("api_user_name", s);
        ii.II("api_user_password", s2);
        return ii.II();
    }
    
    @NotNull
    @Override
    public qk iI(@NotNull final String s) {
        final Pastebin ii = Pastebin.II();
        ii.II("api_option", "userdetails");
        ii.II("api_dev_key", this.II);
        ii.II("api_user_key", s);
        final qk ii2 = ii.II();
        if (ii2.II()) {
            return ql.II(ii2.II());
        }
        try {
            return ql.II(qu.II((String)ii2.II()));
        }
        catch (ParserConfigurationException | IOException | SAXException ex) {
            final Object o;
            return ql.II(((Throwable)o).getMessage());
        }
    }
    
    @NotNull
    @Override
    public qk Ii(@NotNull final String s) {
        return this.II(s, 50);
    }
    
    @NotNull
    @Override
    public qk II(@NotNull final String s, final int n) {
        final Pastebin ii = Pastebin.II();
        ii.II("api_option", "list");
        ii.II("api_dev_key", this.II);
        ii.II("api_user_key", s);
        ii.II("api_results_limit", String.valueOf(n));
        final qk ii2 = ii.II();
        if (ii2.II()) {
            return ql.II(ii2.II());
        }
        final String s2 = (String)ii2.II();
        if (s2.contains("Bad API request")) {
            return ql.II(s2);
        }
        if ("No pastes found.".equals(s2)) {
            return ql.II(Collections.emptyList());
        }
        final String string = "<root>" + s2 + "</root>";
        try {
            return ql.II(qh.II(string));
        }
        catch (SAXException | IOException | ParserConfigurationException ex) {
            final Object o;
            return ql.II(((Throwable)o).getMessage());
        }
    }
    
    @Override
    public qk iI(@NotNull final String s, @NotNull final String s2) {
        final Pastebin ii = Pastebin.II();
        ii.II("api_option", "delete");
        ii.II("api_dev_key", this.II);
        ii.II("api_paste_key", s);
        ii.II("api_user_key", s2);
        final qk ii2 = ii.II();
        if (ii2.II()) {
            return ql.II(ii2.II());
        }
        final String s3 = (String)ii2.II();
        if (s3.contains("Bad API request")) {
            return ql.II(s3);
        }
        if ("Paste Removed".equals(s3)) {
            return ql.II(true);
        }
        return ql.II(s3);
    }
}
