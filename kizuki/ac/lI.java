package kizuki.ac;

import kizuki.ac.utils.gui.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class lI
{
    @Nullable
    public static ChestButton II(final int n, final ArrayList list) {
        for (final ChestButton chestButton : list) {
            if (chestButton.II() == n) {
                return chestButton;
            }
        }
        return null;
    }
}
