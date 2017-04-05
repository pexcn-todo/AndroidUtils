package me.pexcn.android.utils.component;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;

import java.lang.reflect.Field;
import java.util.List;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ActivityUtils {
    private ActivityUtils() {
    }

    /**
     * 是否存在 Activity
     *
     * @param packageName 应用程序包名
     * @param className   应用程序类名
     * @return 是否存在此 Activity
     */
    public static boolean isExists(String packageName, String className) {
        final Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return !(Utils.getContext().getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(Utils.getContext().getPackageManager()) == null ||
                Utils.getContext().getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * 打开 Activity
     *
     * @param packageName 应用程序包名
     * @param className   应用程序类名
     */
    public static void openActivity(String packageName, String className) {
        openActivity(packageName, className, null);
    }

    /**
     * 打开 Activity
     *
     * @param packageName 应用程序包名
     * @param className   应用程序类名
     * @param bundle      Bundle 管道
     */
    public static void openActivity(String packageName, String className, Bundle bundle) {
        Utils.getContext().startActivity(getComponentIntent(packageName, className, bundle));
    }

    /**
     * 获取组件 Intent
     *
     * @param packageName 应用程序包名
     * @param className   应用程序类名
     * @param bundle      Bundle 管道
     * @return 组件 Intent
     */
    private static Intent getComponentIntent(String packageName, String className, Bundle bundle) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        final ComponentName componentName = new ComponentName(packageName, className);
        intent.setComponent(componentName);
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * 获取 Launcher Activity
     *
     * @param packageName 应用程序包名
     * @return Launcher Activity 的字符串形式
     */
    public static String getLauncherActivity(String packageName) {
        final Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        final PackageManager pm = Utils.getContext().getPackageManager();
        final List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "No " + packageName;
    }

    /**
     * 获取栈顶 Activity
     *
     * @return 栈顶 Activity
     */
    @SuppressWarnings("unchecked")
    public static Activity getTopActivity() {
        try {
            final Class activityThreadClass = Class.forName("android.app.ActivityThread");
            final Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
            final Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            final ArrayMap activities = (ArrayMap) activitiesField.get(activityThread);
            for (Object activityRecord : activities.values()) {
                final Class activityRecordClass = activityRecord.getClass();
                final Field pausedField = activityRecordClass.getDeclaredField("paused");
                pausedField.setAccessible(true);
                if (!pausedField.getBoolean(activityRecord)) {
                    final Field activityField = activityRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    return (Activity) activityField.get(activityRecord);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
