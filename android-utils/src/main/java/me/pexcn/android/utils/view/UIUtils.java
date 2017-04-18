package me.pexcn.android.utils.view;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-10-21.
 */
@SuppressWarnings("unused")
public class UIUtils {
    private UIUtils() {
    }

    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度
     */
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = Utils.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = Utils.getContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
