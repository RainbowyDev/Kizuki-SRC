package kizuki.ac.utils.paste;

import org.xml.sax.helpers.*;
import kizuki.ac.*;

public class UserHandler extends DefaultHandler
{
    private final qv II;
    private StringBuilder II;
    
    public UserHandler() {
        this.II = new qt();
        this.II = new StringBuilder();
    }
    
    @Override
    public void characters(final char[] array, final int n, final int n2) {
        this.II.append(array, n, n2);
    }
    
    @Override
    public void endElement(final String s, final String s2, final String s3) {
        final String string = this.II.toString();
        switch (s3) {
            case "user_name": {
                this.II.II(string);
                break;
            }
            case "user_avatar_url": {
                this.II.iI(string);
                break;
            }
            case "user_website": {
                this.II.Ii(string);
                break;
            }
            case "user_email": {
                this.II.ii(string);
                break;
            }
            case "user_location": {
                this.II.ll(string);
                break;
            }
            case "user_account_type": {
                this.II.II(qx.II(Integer.parseInt(string)));
                break;
            }
            case "user_format_short": {
                this.II.lI(string);
                break;
            }
            case "user_expiration": {
                this.II.II(qf.II(string));
                break;
            }
            case "user_private": {
                this.II.II(qg.II(Integer.parseInt(string)));
                break;
            }
        }
        this.II = new StringBuilder();
    }
    
    public qc II() {
        return this.II.II();
    }
}
