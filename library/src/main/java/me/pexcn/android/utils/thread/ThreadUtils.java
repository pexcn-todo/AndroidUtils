package me.pexcn.android.utils.thread;

import android.os.Looper;

/**
 * Created by pexcn on 2016-10-21.
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
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
