package kizuki.ac.utils.paste;

import org.xml.sax.helpers.*;
import java.util.*;
import org.xml.sax.*;
import kizuki.ac.*;

public class PasteHandler extends DefaultHandler
{
    private static final String II = "paste";
    private static final String iI = "paste_key";
    private static final String Ii = "paste_date";
    private static final String ii = "paste_title";
    private static final String ll = "paste_format_long";
    private static final String lI = "paste_format_short";
    private static final String Il = "paste_hits";
    private static final String LL = "paste_private";
    private static final String qq = "paste_size";
    private static final String qw = "paste_expire_date";
    private final List II;
    private boolean II;
    private String qe;
    private qd II;
    
    public PasteHandler() {
        this.II = new ArrayList();
    }
    
    @Override
    public void endDocument() {
        if (this.II != null) {
            this.II.add(this.II.II());
            this.qe = "Untitled";
        }
    }
    
    @Override
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        this.II = true;
        if (s3.equals("paste")) {
            if (this.II != null) {
                this.II.add(this.II.II());
                this.II = null;
            }
            this.II = new qe();
        }
    }
    
    @Override
    public void endElement(final String s, final String s2, final String s3) {
        this.II = false;
        switch (s3) {
            case "paste_key": {
                this.II.II(this.qe);
                break;
            }
            case "paste_title": {
                this.II.iI(this.qe);
                break;
            }
            case "paste_format_long": {
                this.II.Ii(this.qe);
                break;
            }
            case "paste_format_short": {
                this.II.ii(this.qe);
                break;
            }
            case "paste_hits": {
                this.II.II(Integer.parseInt(this.qe));
                break;
            }
            case "paste_private": {
                this.II.II(qg.II(Integer.parseInt(this.qe)));
                break;
            }
            case "paste_size": {
                this.II.II(Long.parseLong(this.qe));
                break;
            }
            case "paste_date": {
                this.II.iI(Long.parseLong(this.qe) * 1000L);
                break;
            }
            case "paste_expire_date": {
                this.II.Ii(Long.parseLong(this.qe) * 1000L);
                break;
            }
        }
    }
    
    @Override
    public void characters(final char[] array, final int n, final int n2) {
        if (this.II) {
            this.qe = new String(array, n, n2);
            this.II = false;
        }
    }
    
    public List II() {
        return this.II;
    }
}
