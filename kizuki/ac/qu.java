package kizuki.ac;

import org.jetbrains.annotations.*;
import kizuki.ac.utils.paste.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import org.xml.sax.helpers.*;

public class qu
{
    @NotNull
    public static qc II(@NotNull final String s) {
        final UserHandler userHandler = new UserHandler();
        SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(s)), userHandler);
        return userHandler.II();
    }
}
