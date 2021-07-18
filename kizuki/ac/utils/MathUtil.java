package kizuki.ac.utils;

import com.google.common.util.concurrent.*;
import java.util.function.*;
import org.bukkit.util.*;
import com.google.common.collect.*;
import kizuki.ac.*;
import java.util.*;
import java.math.*;

public final class MathUtil
{
    private static final double II = 0.017453292519943295;
    private static final double iI = 57.29577951308232;
    private static final double Ii = 2.409919865102884E-181;
    private static final double ii = 4.149515568880993E180;
    private static final int II = 53;
    private static final int iI = 1023;
    private static final long II = 9218868437227405312L;
    private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    static final /* synthetic */ boolean II;
    
    private MathUtil() {
    }
    
    public static double getKurtosis(final Collection collection) {
        final double n = collection.size();
        if (n < 3.0) {
            return Double.NaN;
        }
        final double average2 = getAverage2(collection);
        final double variance = getVariance(collection);
        final AtomicDouble atomicDouble = new AtomicDouble(0.0);
        final Iterator<Number> iterator = collection.iterator();
        while (iterator.hasNext()) {
            atomicDouble.getAndAdd(Math.pow(iterator.next().doubleValue() - average2, 4.0));
        }
        return n * (n + 1.0) / ((n - 1.0) * (n - 2.0) * (n - 3.0)) * (atomicDouble.get() / Math.pow(variance, 4.0)) - 3.0 * Math.pow(n - 1.0, 2.0) / ((n - 2.0) * (n - 3.0));
    }
    
    public static double getVariance(final Collection collection) {
        getAverage2(collection);
        final AtomicDouble atomicDouble = new AtomicDouble(0.0);
        final double n2;
        collection.forEach(n -> atomicDouble.getAndAdd(Math.pow(n.doubleValue() - n2, 2.0)));
        return Math.sqrt(atomicDouble.get() / collection.size());
    }
    
    public static double getAverage2(final Collection collection) {
        return collection.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
    }
    
    public static int II(final double n) {
        final int n2 = (int)n;
        return (n < n2) ? (n2 - 1) : n2;
    }
    
    public static Vector getVectorForRotation(final float n, final float n2) {
        final Vector vector = new Vector();
        final float n3 = (float)Math.toRadians(n);
        final float n4 = (float)Math.toRadians(n2);
        vector.setY(-sin(n4));
        final double n5 = cos(n4);
        vector.setX(-n5 * sin(n3));
        vector.setZ(n5 * cos(n3));
        return vector;
    }
    
    public static String II() {
        final String s = "78 121 96 38 100 67 82 82 90 103 110 115 95 88 87 99 81 81 80 32 39 77 102 108 81 78 99 75 76 120 77 36";
        String string = "";
        final String[] split = s.split(" ");
        for (int length = split.length, i = 0; i < length; ++i) {
            string += Character.toString((char)(Integer.parseInt(split[i]) ^ 0x14));
        }
        return string;
    }
    
    public static double II(final double n, final double n2) {
        return Math.abs(n - n2);
    }
    
    public static float II(final long n, final float n2, final float n3) {
        return (float)II(n, (int)n2, (int)n3);
    }
    
    public static double hypot(final double... array) {
        double n = 0.0;
        for (final double n2 : array) {
            n += n2 * n2;
        }
        return Math.sqrt(n);
    }
    
    public static int II(final float n, final float n2) {
        return (int)(n / n2 + Math.max(n, n2) * 0.001f);
    }
    
    public static float getGcd(final float n, final float n2) {
        if (n <= 1.0E-4) {
            return n2;
        }
        float n3 = (n2 / n - II(n2, n)) * n;
        if (Math.abs(n3) < Math.max(n, n2) * 0.001f) {
            n3 = 0.0f;
        }
        return getGcd(n3, n);
    }
    
    public static float II(final Queue queue) {
        float n = (float)queue.toArray()[0];
        for (int i = 1; i < queue.size(); ++i) {
            n = getGcd((float)queue.toArray()[i], n);
        }
        return n;
    }
    
    public static double iI(final double n, final double n2) {
        return Math.exp(Math.log(n) / n2);
    }
    
    public static long II(final long n, final long n2, final long n3) {
        return (n3 <= n) ? n2 : II(n, n3, n2 % n3);
    }
    
    public static double getAverage(final Iterable iterable) {
        final long n = (iterable instanceof Collection) ? ((Collection<Number>)iterable).size() : Iterators.size((Iterator)iterable.iterator());
        if (n == 0L) {
            throw new IllegalArgumentException("Iterable is empty");
        }
        double n2 = 0.0;
        final Iterator<Number> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            n2 += iterator.next().doubleValue();
        }
        return n2 / n;
    }
    
    public static float sin(final float n) {
        try {
            final Class ii = tw.II("MathHelper");
            if (!MathUtil.II && ii == null) {
                throw new AssertionError();
            }
            return (float)ii.getMethod("sin", Float.TYPE).invoke(ii, n);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return (float)Math.sin(n);
        }
    }
    
    public static float cos(final float n) {
        try {
            final Class ii = tw.II("MathHelper");
            if (!MathUtil.II && ii == null) {
                throw new AssertionError();
            }
            return (float)ii.getMethod("cos", Float.TYPE).invoke(ii, n);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return (float)Math.cos(n);
        }
    }
    
    public static int getDistinct(final Collection collection) {
        return new HashSet(collection).size();
    }
    
    public static double getVariance(final Collection collection) {
        double n = 0.0;
        final Iterator<Number> iterator = collection.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().doubleValue();
        }
        final double n2 = n / collection.size();
        double n3 = 0.0;
        final Iterator<Number> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            n3 += Math.pow(iterator2.next().doubleValue() - n2, 2.0);
        }
        return Math.sqrt(n3 / (collection.size() - 1));
    }
    
    public static boolean II(final Number n, final Number n2, final Number n3) {
        return n.doubleValue() >= n2.doubleValue() && n.doubleValue() <= n3.doubleValue();
    }
    
    public static strictfp double Ii(final double n, final double n2) {
        double abs = Math.abs(n);
        double abs2 = Math.abs(n2);
        if (!Double.isFinite(abs) || !Double.isFinite(abs2)) {
            if (abs == Double.POSITIVE_INFINITY || abs2 == Double.POSITIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            return abs + abs2;
        }
        else {
            if (abs2 > abs) {
                final double n3 = abs;
                abs = abs2;
                abs2 = n3;
            }
            if (!MathUtil.II && abs < abs2) {
                throw new AssertionError();
            }
            int ii = iI(abs);
            int ii2 = iI(abs2);
            if (ii - ii2 > 62914560) {
                return abs + abs2;
            }
            int n4 = 0;
            if (abs > 3.2733937296446915E150) {
                ii -= 629145600;
                ii2 -= 629145600;
                abs *= 2.409919865102884E-181;
                abs2 *= 2.409919865102884E-181;
                n4 += 600;
            }
            if (abs2 < 3.0549363634996047E-151) {
                if (abs2 < Double.MIN_NORMAL) {
                    if (abs2 == 0.0) {
                        return abs;
                    }
                    final double n5 = 4.49423283715579E307;
                    abs2 *= n5;
                    abs *= n5;
                    n4 -= 1022;
                }
                else {
                    ii += 629145600;
                    ii2 += 629145600;
                    abs *= 4.149515568880993E180;
                    abs2 *= 4.149515568880993E180;
                    n4 -= 600;
                }
            }
            final double n6 = abs - abs2;
            double n7;
            if (n6 > abs2) {
                final double ii3 = II(0.0, ii);
                n7 = Math.sqrt(ii3 * ii3 - (abs2 * -abs2 - (abs - ii3) * (abs + ii3)));
            }
            else {
                final double n8 = abs + abs;
                final double ii4 = II(0.0, ii2);
                final double n9 = abs2 - ii4;
                final double ii5 = II(0.0, ii + 1048576);
                n7 = Math.sqrt(ii5 * ii4 - (n6 * -n6 - (ii5 * n9 + (n8 - ii5) * abs2)));
            }
            if (n4 != 0) {
                return II(n4) * n7;
            }
            return n7;
        }
    }
    
    private static double II(final double n, final int n2) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(n) & 0xFFFFFFFFL) | (long)n2 << 32);
    }
    
    private static int iI(final double n) {
        return (int)(Double.doubleToRawLongBits(n) >> 32);
    }
    
    static double II(final int n) {
        if (!MathUtil.II && (n < -1022 || n > 1023)) {
            throw new AssertionError();
        }
        return Double.longBitsToDouble(n + 1023L << 52 & 0x7FF0000000000000L);
    }
    
    public static double toRadians(final double n) {
        return n * 0.017453292519943295;
    }
    
    public static double iI(final double n) {
        return n * 57.29577951308232;
    }
    
    public static int II(final int n, final int n2) {
        return II(0, n, n2);
    }
    
    public static int II(final int n, int i, int n2) {
        if (n2 <= n) {
            return i;
        }
        if (i <= n) {
            return n2;
        }
        final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        final int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(n2);
        i >>>= numberOfTrailingZeros;
        n2 >>>= numberOfTrailingZeros2;
        final int min = Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
        while (i != n2) {
            if (i + Integer.MIN_VALUE > n2 + Integer.MIN_VALUE) {
                i -= n2;
                i >>>= Integer.numberOfTrailingZeros(i);
            }
            else {
                n2 -= i;
                n2 >>>= Integer.numberOfTrailingZeros(n2);
            }
        }
        return i << min;
    }
    
    public static double II(final float n, final float n2) {
        float n3 = Math.abs(n - n2) % 360.0f;
        if (n3 > 180.0f) {
            n3 = 360.0f - n3;
        }
        return n3;
    }
    
    public static boolean isEulerSmall(final Number n) {
        return n.doubleValue() < 1.0 && Double.toString(n.doubleValue()).contains("E");
    }
    
    public static BigDecimal II(final float n, final int n2) {
        return new BigDecimal(Float.toString(n)).setScale(n2, 4);
    }
    
    public boolean isEulerBig(final Number n) {
        return n.doubleValue() > 10000.0 && Double.toString(n.doubleValue()).contains("E");
    }
    
    static {
        II = !MathUtil.class.desiredAssertionStatus();
    }
}
