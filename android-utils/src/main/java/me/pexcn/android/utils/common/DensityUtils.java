package me.pexcn.android.utils.common;

import android.util.DisplayMetrics;
import android.util.TypedValue;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-11-02.
 */
@SuppressWarnings("unused")
public class DensityUtils {
    private DensityUtils() {
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
