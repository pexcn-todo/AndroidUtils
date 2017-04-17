package me.pexcn.android.utils.cache;

import android.os.Environment;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings("WeakerAccess")
public class CacheUtils {
    public static final long SIZE_LARGE = 128 * 1024 * 1024;
    public static final long SIZE_MEDIUM = 32 * 1024 * 1024;
    public static final long SIZE_SMALL = 8 * 1024 * 1024;

    public static final String PATH_INTERNAL = Utils.getContext().getCacheDir().getPath();
    public static final String PATH_EXTERNAL = Environment.MEDIA_MOUNTED
            .equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()
            ? Utils.getContext().getExternalCacheDir().getPath() : PATH_INTERNAL;

}
