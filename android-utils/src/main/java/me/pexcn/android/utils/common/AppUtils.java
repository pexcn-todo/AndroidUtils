package me.pexcn.android.utils.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-09-26.
 */
@SuppressWarnings("unused")
public class AppUtils {
    private AppUtils() {
    }

    /**
     * 获取当前版本的 Version Code
     *
     * @return 版本号
     */
    public static int getVersionCode() {
        final Context context = Utils.getContext();
        final PackageManager pm = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        assert info != null;
        return info.versionCode;
    }

    /**
     * 获取当前版本的 Version Name
     *
     * @return 版本名称
     */
    public static String getVersionName() {
        final Context context = Utils.getContext();
        final PackageManager pm = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        assert info != null;
        return info.versionName;
    }
}
