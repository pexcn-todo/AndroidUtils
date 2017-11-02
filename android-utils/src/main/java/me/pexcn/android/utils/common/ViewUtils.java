package me.pexcn.android.utils.common;

import static android.view.View.MeasureSpec;

/**
 * Created by pexcn on 2017-10-24.
 */
@SuppressWarnings("unused")
public class ViewUtils {
    private ViewUtils() {
    }

    /**
     * 获取 View 测量的大小
     *
     * @param defaultSize 默认大小
     * @param measureSpec 测量规格
     * @return View 的大小
     */
    public static int getMeasureDimension(int defaultSize, int measureSpec) {
        int result;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(defaultSize, specSize);
                break;
            case MeasureSpec.UNSPECIFIED:
            default:
                result = defaultSize;
                break;
        }

        return result;
    }
}
