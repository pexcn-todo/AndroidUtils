package me.pexcn.android.utils.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-09-26.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class CacheUtils {
    private static final LruCache<String, Object> CACHE =
            new LruCache<>(Utils.getInstance().getMemCacheSize());

    private static final LruCache<String, Bitmap> BITMAP_CACHE =
            new LruCache<String, Bitmap>(Utils.getInstance().getMemCacheSize()) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getByteCount() / 1024;
                }

                @Override
                protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                    super.entryRemoved(evicted, key, oldValue, newValue);
                    if (evicted && oldValue != null) {
                        oldValue.recycle();
                    }
                }
            };

    private CacheUtils() {
    }

    public static void put(String key, Object data) {
        CACHE.put(key, data);
    }

    public static Object get(String key) {
        return CACHE.get(key);
    }

    public static Object remove(String key) {
        return CACHE.remove(key);
    }

    public static void putBitmap(String key, Bitmap bitmap) {
        BITMAP_CACHE.put(key, bitmap);
    }

    public static Bitmap getBitmap(String key) {
        return BITMAP_CACHE.get(key);
    }

    public static Bitmap removeBitmap(String key) {
        return BITMAP_CACHE.remove(key);
    }
}
