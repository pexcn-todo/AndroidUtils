package me.pexcn.android.utils.component;

import android.content.Intent;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntentUtils {
    private IntentUtils() {
    }

    /**
     * 获取要打开应用程序的 Intent
     *
     * @param packageName 应用程序包名
     * @return Intent
     */
    public static Intent getIntent(String packageName) {
        return Utils.getContext().getPackageManager().getLaunchIntentForPackage(packageName);
    }
}
