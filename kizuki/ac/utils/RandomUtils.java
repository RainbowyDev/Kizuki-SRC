package kizuki.ac.utils;

import java.util.concurrent.*;

public class RandomUtils
{
    public static int randomInt(final int n) {
        return ThreadLocalRandom.current().nextInt(n);
    }
    
    public static int randomInt(final int n, final int n2) {
        return ThreadLocalRandom.current().nextInt(n, n2);
    }
    
    public static double randomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }
    
    public static double randomDouble(final double n) {
        return ThreadLocalRandom.current().nextDouble(n);
    }
    
    public static double randomDouble(final double n, final double n2) {
        return ThreadLocalRandom.current().nextDouble(n, n2);
    }
    
    public static float randomFloat() {
        return ThreadLocalRandom.current().nextFloat();
    }
    
    public static float randomFloat(final float n) {
        if (n <= 0.0f) {
            throw new IllegalArgumentException("the border must be greater than zero");
        }
        final float n2 = ThreadLocalRandom.current().nextFloat() * n;
        return (n2 < n) ? n2 : Float.intBitsToFloat(Float.floatToIntBits(n) - 1);
    }
    
    public static float randomFloat(final float n, final float n2) {
        if (n >= n2) {
            throw new IllegalArgumentException("The border must be greater than the beginning");
        }
        float n3 = ThreadLocalRandom.current().nextFloat();
        if (n < n2) {
            n3 = n3 * (n2 - n) + n;
            if (n3 >= n2) {
                n3 = Float.intBitsToFloat(Float.floatToIntBits(n2) - 1);
            }
        }
        return n3;
    }
    
    public static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
