package me.pexcn.android.utils.common;

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
