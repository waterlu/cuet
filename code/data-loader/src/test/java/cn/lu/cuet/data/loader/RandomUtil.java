package cn.lu.cuet.data.loader;

import java.util.Random;

/**
 * Created by mofang on 18/10/16.
 */
public class RandomUtil {

    private static Random seed = new Random();

    public static int getRandom(int min, int max){
        int range = max - min;
        int random = seed.nextInt(range);
        int value = min + random;
        return value;
    }
}
