package me.pexcn.android.utils.ui;

import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;

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

    /**
     * 获取 ListView 整体的高度
     *
     * @param listView ListView 对象
     * @return ListView 高度
     */
    public static int getListViewHeight(ListView listView) {
        int totalHeight = 0;
        ListAdapter adapter = listView.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            View item = adapter.getView(i, null, listView);
            item.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int itemHeight = item.getMeasuredHeight() + listView.getDividerHeight();
            totalHeight += itemHeight;
        }
        return totalHeight;
    }
}
