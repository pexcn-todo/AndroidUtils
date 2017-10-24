package me.pexcn.android.utils.samples;

import android.graphics.BitmapFactory;
import android.view.View;

import me.pexcn.android.base.ui.BaseActivity;
import me.pexcn.android.utils.common.LogUtils;
import me.pexcn.android.utils.cache.CacheHelper;
import me.pexcn.android.utils.cache.CachePath;
import me.pexcn.android.utils.cache.CacheSize;
import me.pexcn.android.utils.encrypt.MD5Utils;

/**
 * Created by pexcn on 2017-04-18.
 */
public class MainActivity extends BaseActivity {
    private static final String STRING = "Android!";
    private static final String KEY_STRING = MD5Utils.get(STRING);
    private static final String KEY_BITMAP = MD5Utils.get("Bitmap");

    private CacheHelper mCacheHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mCacheHelper = new CacheHelper(CachePath.PATH_INTERNAL, CacheSize.SMALL);

        findViewById(R.id.write_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCacheHelper.putString(KEY_STRING, STRING);
                mCacheHelper.putBitmap(KEY_BITMAP, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            }
        });

        findViewById(R.id.read_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCacheHelper.isCached(KEY_STRING)) {
                    LogUtils.d(mCacheHelper.getString(KEY_STRING));
                } else {
                    LogUtils.d("String no cache.");
                }
                if (mCacheHelper.isCached(KEY_BITMAP)) {
                    LogUtils.d(mCacheHelper.getBitmap(KEY_BITMAP).toString());
                } else {
                    LogUtils.d("Bitmap no cache.");
                }
            }
        });

        findViewById(R.id.remove_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCacheHelper.remove(KEY_STRING);
                mCacheHelper.remove(KEY_BITMAP);
            }
        });
    }
}
