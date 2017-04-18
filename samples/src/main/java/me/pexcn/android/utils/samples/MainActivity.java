package me.pexcn.android.utils.samples;

import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import me.pexcn.android.base.ui.BaseActivity;
import me.pexcn.android.utils.cache.CacheHelper;
import me.pexcn.android.utils.encrypt.MD5Utils;
import me.pexcn.android.utils.io.LogUtils;
import me.pexcn.android.utils.view.SnackbarUtils;

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
        mCacheHelper = new CacheHelper(CacheHelper.PATH_INTERNAL, CacheHelper.SIZE_SMALL);

        findViewById(R.id.write_cache).setOnClickListener(v -> {
            mCacheHelper.putString(KEY_STRING, STRING);
            mCacheHelper.putBitmap(KEY_BITMAP, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        });

        findViewById(R.id.read_cache).setOnClickListener(v -> {
            if (mCacheHelper.cached(KEY_STRING)) {
                LogUtils.d(mCacheHelper.getString(KEY_STRING));
            } else {
                LogUtils.d("String no cache.");
            }
            if (mCacheHelper.cached(KEY_BITMAP)) {
                LogUtils.d(mCacheHelper.getBitmap(KEY_BITMAP).toString());
            } else {
                LogUtils.d("Bitmap no cache.");
            }
        });

        findViewById(R.id.remove_cache).setOnClickListener(v -> {
            mCacheHelper.remove(KEY_STRING);
            mCacheHelper.remove(KEY_BITMAP);
        });

        findViewById(R.id.show_snackbar).setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.root_view), "SnackBar!", Snackbar.LENGTH_INDEFINITE);
            SnackbarUtils.setBackgroundColor(snackbar, ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
            SnackbarUtils.setMessageColor(snackbar, ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
            snackbar.show();
        });
    }
}
