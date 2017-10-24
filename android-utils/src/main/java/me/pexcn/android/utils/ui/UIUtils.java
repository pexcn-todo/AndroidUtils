package me.pexcn.android.utils.ui;

import android.os.Looper;

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

    /**
     * 当前线程是否为 UI 线程
     *
     * @return 是否为 UI 线程
     */
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
