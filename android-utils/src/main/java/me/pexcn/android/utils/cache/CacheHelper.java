package me.pexcn.android.utils.cache;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import libcore.io.DiskLruCache;
import me.pexcn.android.utils.Utils;
import me.pexcn.android.utils.common.PackageUtils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CacheHelper {
    public static final long SIZE_SMALL = 16 * 1024 * 1024;
    public static final long SIZE_MEDIUM = 64 * 1024 * 1024;
    public static final long SIZE_LARGE = 128 * 1024 * 1024;

    public static final String PATH_INTERNAL = Utils.getContext().getCacheDir().getAbsolutePath() + File.separator + "lru_cache";
    @SuppressWarnings("ConstantConditions")
    public static final String PATH_EXTERNAL = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()
            ? Utils.getContext().getExternalCacheDir().getAbsolutePath() + File.separator + "lru_cache" : PATH_INTERNAL;

    private DiskLruCache mDiskLruCache;

    /**
     * 默认缓存文件目录为内部目录，最大缓存大小为 64 MB
     */
    public CacheHelper() {
        mDiskLruCache = generateCache(PATH_INTERNAL, SIZE_MEDIUM);
    }

    public CacheHelper(String dir) {
        mDiskLruCache = generateCache(dir, SIZE_MEDIUM);
    }

    public CacheHelper(String dir, long maxSize) {
        mDiskLruCache = generateCache(dir, maxSize);
    }

    private DiskLruCache generateCache(String dir, long maxSize) {
        File cacheDir = new File(dir);
        int appVersion = PackageUtils.getVersionCode();
        int valueCount = 1;
        try {
            return DiskLruCache.open(cacheDir, appVersion, valueCount, maxSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据 key 写入缓存
     *
     * @param key 与缓存对应的 key
     * @param obj 要缓存的对象
     */
    public void put(String key, Object obj) {
        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(key);
            OutputStream os = editor.newOutputStream(0);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 key 获取 LruCache 缓存
     *
     * @param key 与缓存对应的 key
     * @return LruCache 缓存
     */
    public Object get(String key) {
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                InputStream is = snapshot.getInputStream(0);
                ObjectInputStream ois = new ObjectInputStream(is);
                return ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
