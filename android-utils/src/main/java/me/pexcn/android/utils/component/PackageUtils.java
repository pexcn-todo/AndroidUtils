package me.pexcn.android.utils.component;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-09-26.
 */
@SuppressWarnings("unused")
public class PackageUtils {
    private PackageUtils() {
    }

    /**
     * 获取当前版本的 Version Code
     *
     * @return Version Code
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
     * @return Version Name
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
