package me.pexcn.android.utils.io;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import me.pexcn.android.utils.Utils;


/**
 * Created by pexcn on 2016-09-21.
 */
@SuppressWarnings("unused")
public class PreferencesUtils {
    private static final SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(Utils.getContext());

    private PreferencesUtils() {
    }

    /**
     * 获取 key 所对应的布尔值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 布尔值
     */
    public static boolean getBoolean(String key, boolean defValue) {
        return SP.getBoolean(key, defValue);
    }

    /**
     * 根据 key 设置布尔值
     *
     * @param key   键
     * @param value 值
     */
    public static void setBoolean(String key, boolean value) {
        SP.edit().putBoolean(key, value).apply();
    }

    /**
     * 获取 key 对应的字符串值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 字符串值
     */
    public static String getString(String key, String defValue) {
        return SP.getString(key, defValue);
    }

    /**
     * 根据 key 设置字符串值
     *
     * @param key   键
     * @param value 值
     */
    public static void setString(String key, String value) {
        SP.edit().putString(key, value).apply();
    }

    /**
     * 获取 key 对应的整形值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 整形值
     */
    public static int getInt(String key, int defValue) {
        return SP.getInt(key, defValue);
    }

    /**
     * 根据 key 设置整形值
     *
     * @param key   键
     * @param value 值
     */
    public static void setInt(String key, int value) {
        SP.edit().putInt(key, value).apply();
    }

    /**
     * 获取 key 对应的长整形值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 长整形值
     */
    public static long getLong(String key, long defValue) {
        return SP.getLong(key, defValue);
    }

    /**
     * 根据 key 设置长整形值
     *
     * @param key   键
     * @param value 值
     */
    public static void setLong(String key, long value) {
        SP.edit().putLong(key, value).apply();
    }

    /**
     * 获取 key 对应的浮点型值
     *
     * @param key      键
     * @param defValue 默认值
     * @return 浮点型值
     */
    public static float getFloat(String key, float defValue) {
        return SP.getFloat(key, defValue);
    }

    /**
     * 根据 key 设置浮点型值
     *
     * @param key   键
     * @param value 值
     */
    public static void setFloat(String key, float value) {
        SP.edit().putFloat(key, value).apply();
    }
}
