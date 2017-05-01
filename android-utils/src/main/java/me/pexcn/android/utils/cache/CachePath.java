package me.pexcn.android.utils.cache;

import android.os.Environment;

import java.io.File;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-05-01.
 */
@SuppressWarnings({"ConstantConditions", "WeakerAccess", "unused"})
public interface CachePath {
    String PATH_INTERNAL = Utils.getContext().getCacheDir().getAbsolutePath() + File.separator + "lru_cache";
    String PATH_EXTERNAL = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()
            ? Utils.getContext().getExternalCacheDir().getAbsolutePath() + File.separator + "lru_cache" : PATH_INTERNAL;
}
