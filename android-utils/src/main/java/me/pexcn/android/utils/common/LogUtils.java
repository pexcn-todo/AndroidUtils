package me.pexcn.android.utils.common;

import android.util.Log;

/**
 * Created by pexcn on 2016-09-21.
 */
@SuppressWarnings("unused")
public class LogUtils {
    private static final String TAG = LogUtils.class.getSimpleName();

    private LogUtils() {
    }

    /**
     * Log.v()
     *
     * @param msg 字符串形式的日志
     */
    public static void v(String msg) {
        Log.v(TAG, msg);
    }

    /**
     * Log.d()
     *
     * @param msg 字符串形式的日志
     */
    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * Log.i()
     *
     * @param msg 字符串形式的日志
     */
    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    /**
     * Log.w()
     *
     * @param msg 字符串形式的日志
     */
    public static void w(String msg) {
        Log.w(TAG, msg);
    }

    /**
     * Log.e()
     *
     * @param msg 字符串形式的日志
     */
    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    /**
     * Log.wtf()
     *
     * @param msg 字符串形式的日志
     */
    public static void wtf(String msg) {
        Log.wtf(TAG, msg);
    }
}
