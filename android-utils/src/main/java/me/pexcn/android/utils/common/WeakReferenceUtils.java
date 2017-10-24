package me.pexcn.android.utils.common;

import java.lang.ref.WeakReference;

/**
 * Created by pexcn on 2016-09-25.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class WeakReferenceUtils {
    private WeakReferenceUtils() {
    }

    /**
     * 获取弱引用对象
     *
     * @param reference WeakReference 引用
     * @param <T>       泛型
     * @return T 类型
     */
    public static <T> T get(WeakReference<T> reference) {
        return reference == null ? null : reference.get();
    }

    /**
     * 清理弱引用对象
     *
     * @param reference WeakReference 引用
     * @param <T>       泛型
     */
    public static <T> void clear(WeakReference<T> reference) {
        if (reference != null) {
            reference.clear();
        }
    }
}
