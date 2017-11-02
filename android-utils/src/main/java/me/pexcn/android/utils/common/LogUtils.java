package me.pexcn.android.utils.common;

import android.util.Log;

/**
 * Created by pexcn on 2016-09-21.
 */
@SuppressWarnings("unused")
public class LogUtils {
    private static boolean DEBUG = true;
    private static String TAG = LogUtils.class.getSimpleName();

    private LogUtils() {
    }

    /**
     * Log.v()
     *
     * @param msg 字符串形式的日志
     */
    public static void v(String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

    /**
     * Log.d()
     *
     * @param msg 字符串形式的日志
     */
    public static void d(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    /**
     * Log.i()
     *
     * @param msg 字符串形式的日志
     */
    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    /**
     * Log.w()
     *
     * @param msg 字符串形式的日志
     */
    public static void w(String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    /**
     * Log.e()
     *
     * @param msg 字符串形式的日志
     */
    public static void e(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    /**
     * Log.wtf()
     *
     * @param msg 字符串形式的日志
     */
    public static void wtf(String msg) {
        if (DEBUG) {
            Log.wtf(TAG, msg);
        }
    }

    /**
     * 设置是否开启日志
     *
     * @param debugable 是否开启日志
     */
    public static void setDebug(boolean debugable) {
        DEBUG = debugable;
    }

    /**
     * 设置日志标签
     *
     * @param tag 日志标签
     */
    public static void setTag(String tag) {
        TAG = tag;
    }
}
