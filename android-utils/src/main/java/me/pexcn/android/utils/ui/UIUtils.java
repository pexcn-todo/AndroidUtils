package me.pexcn.android.utils.ui;

import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;

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

    /**
     * DIP 转 PX
     *
     * @param dp 密度
     * @return 像素
     */
    public static float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Utils.getContext().getResources().getDisplayMetrics());
    }

    /**
     * PX 转 DIP
     *
     * @param px 像素
     * @return 密度
     */
    public static float px2dp(int px) {
        return px / (Utils.getContext().getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
