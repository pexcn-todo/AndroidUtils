package me.pexcn.android.utils.common;

import android.os.Build;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pexcn on 2017-10-24.
 */
@SuppressWarnings("unused")
public class RandomUtils {
    private RandomUtils() {
    }

    /**
     * 获得一定范围内的随机数
     *
     * @param min 随机数最小值
     * @param max 随机数最大值
     * @return int 类型的随机数
     */
    public static int nextInt(int min, int max) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ThreadLocalRandom.current().nextInt(min, max + 1);
        } else {
            return new Random().nextInt((max - min) + 1) + min;
        }
    }
}
