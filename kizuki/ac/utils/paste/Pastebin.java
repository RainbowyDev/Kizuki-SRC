package kizuki.ac.utils.paste;

import org.jetbrains.annotations.*;
import kizuki.ac.*;
import java.net.*;
import java.nio.charset.*;
import java.io.*;

public class Pastebin
{
    private static final String II = "https://pastebin.com/api/api_post.php";
    private static final String iI = "https://pastebin.com/raw.php";
    private static final String Ii = "https://pastebin.com/api/api_login.php";
    private final qa II;
    private final String ii;
    
    protected Pastebin(final String ii) {
        this.II = new qa();
        this.ii = ii;
    }
    
    public static Pastebin II() {
        return new Pastebin("https://pastebin.com/api/api_post.php");
    }
    
    public static Pastebin iI() {
        return new Pastebin("https://pastebin.com/raw.php");
    }
    
    public static Pastebin Ii() {
        return new Pastebin("https://pastebin.com/api/api_login.php");
    }
    
    public Pastebin II(@NotNull final String s, @NotNull final String s2) {
        this.II.II(s, s2);
        return this;
    }
    
    public Pastebin II(@NotNull final String s) {
        this.II.II(s);
        return this;
    }
    
    public qk II() {
        HttpURLConnection ii = null;
        try {
            ii = this.II(this.ii);
            ii.setDoOutput(true);
            ii.setRequestMethod("POST");
            this.II(ii.getOutputStream(), this.II);
            return this.II(this.II(ii.getInputStream()));
        }
        catch (IOException ex) {
            return ql.II("Unable to connect to Pastebin endpoint!");
        }
        finally {
            if (ii != null) {
                ii.disconnect();
            }
        }
    }
    
    public qk iI() {
        URLConnection ii = null;
        try {
            ii = this.II(this.ii + "?" + this.II.II());
            return this.II(this.II(ii.getInputStream()));
        }
        catch (IOException ex) {
            return ql.II("Unable to connect to Pastebin endpoint!");
        }
        finally {
            if (ii != null) {
                ((HttpURLConnection)ii).disconnect();
            }
        }
    }
    
    private qk II(final String s) {
        if (s.contains("Bad API request")) {
            return ql.II(s);
        }
        return ql.II((Object)s);
    }
    
    private HttpURLConnection II(final String s) {
        return (HttpURLConnection)URI.create(s).toURL().openConnection();
    }
    
    private String II(@NotNull final InputStream inputStream) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        final StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString();
    }
    
    private void II(final OutputStream outputStream, final qa qa) {
        final byte[] bytes = qa.II().getBytes(StandardCharsets.UTF_8);
        FilterOutputStream filterOutputStream = null;
        try {
            filterOutputStream = new DataOutputStream(outputStream);
            filterOutputStream.write(bytes);
        }
        finally {
            if (filterOutputStream != null) {
                filterOutputStream.close();
            }
        }
    }
}
