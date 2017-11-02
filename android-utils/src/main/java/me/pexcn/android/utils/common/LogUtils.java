package me.pexcn.android.utils.common;

import android.util.Log;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-09-21.
 */
@SuppressWarnings("unused")
public class LogUtils {
    private static boolean DEBUG = true;
    private static Utils TAG = Utils.getInstance();

    private LogUtils() {
    }

    public static void setDebug(boolean debugable) {
        DEBUG = debugable;
    }

    public static void v(String msg) {
        log(TAG, msg, Log.VERBOSE);
    }

    public static void d(String msg) {
        log(TAG, msg, Log.DEBUG);
    }

    public static void i(String msg) {
        log(TAG, msg, Log.INFO);
    }

    public static void w(String msg) {
        log(TAG, msg, Log.WARN);
    }

    public static void e(String msg) {
        log(TAG, msg, Log.ERROR);
    }

    public static <T> void v(T type, String msg) {
        log(type, msg, Log.VERBOSE);
    }

    public static <T> void d(T type, String msg) {
        log(type, msg, Log.DEBUG);
    }

    public static <T> void i(T type, String msg) {
        log(type, msg, Log.INFO);
    }

    public static <T> void w(T type, String msg) {
        log(type, msg, Log.WARN);
    }

    public static <T> void e(T type, String msg) {
        log(type, msg, Log.ERROR);
    }

    private static <T> void log(T type, String msg, int level) {
        if (DEBUG) {
            String tag = type.getClass().getSimpleName();
            switch (level) {
                case Log.ERROR:
                    Log.e(tag, msg);
                    break;
                case Log.INFO:
                    Log.i(tag, msg);
                    break;
                case Log.VERBOSE:
                    Log.v(tag, msg);
                    break;
                case Log.WARN:
                    Log.w(tag, msg);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg);
                    break;
            }
        }
    }
}
