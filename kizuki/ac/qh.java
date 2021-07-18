package kizuki.ac;

import org.jetbrains.annotations.*;
import java.util.*;
import kizuki.ac.utils.paste.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import org.xml.sax.helpers.*;

public class qh
{
    public static qk II(@NotNull final String s) {
        final Pastebin ii = Pastebin.iI();
        ii.II("i", s);
        return ii.iI();
    }
    
    public static List II(final String s) {
        final PasteHandler pasteHandler = new PasteHandler();
        SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(s)), pasteHandler);
        return pasteHandler.II();
    }
}
