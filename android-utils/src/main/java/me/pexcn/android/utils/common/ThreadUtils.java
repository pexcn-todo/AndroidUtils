package me.pexcn.android.utils.common;

import android.os.Build;
import android.os.Looper;

/**
 * Created by pexcn on 2017-11-02.
 */
@SuppressWarnings("unused")
public class ThreadUtils {
    private ThreadUtils() {
    }

    /**
     * 当前线程是否为 UI 线程
     *
     * @return 是否为 UI 线程
     */
    public static boolean isMainThread() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Looper.getMainLooper().isCurrentThread();
        } else {
            return Looper.myLooper() == Looper.getMainLooper();
        }
    }
}
