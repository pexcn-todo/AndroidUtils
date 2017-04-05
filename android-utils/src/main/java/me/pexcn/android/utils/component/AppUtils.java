package me.pexcn.android.utils.component;

import me.pexcn.android.utils.common.StringUtils;

/**
 * Created by pexcn on 2017-04-04.
 */
@SuppressWarnings("unused")
public class AppUtils {
    private AppUtils() {
    }

    /**
     * 是否已安装应用程序
     *
     * @param packageName 应用程序包名
     * @return 是否已安装
     */
    public static boolean isInstalled(String packageName) {
        return !StringUtils.isSpace(packageName) && IntentUtils.getIntent(packageName) != null;
    }
}
