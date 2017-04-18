package me.pexcn.android.utils.view;

import android.support.annotation.ColorInt;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import me.pexcn.android.utils.R;

/**
 * Created by pexcn on 2016-09-21.
 */
public class SnackbarUtils {
    private SnackbarUtils() {
    }

    /**
     * 设置 Snackbar 的背景颜色
     *
     * @param backgroundColor 颜色值
     */
    public static void setBackgroundColor(Snackbar snackbar, @ColorInt int backgroundColor) {
        snackbar.getView().setBackgroundColor(backgroundColor);
    }

    /**
     * 设置 Snackbar 的文字颜色
     *
     * @param messageColor 颜色值
     */
    public static void setMessageColor(Snackbar snackbar, @ColorInt int messageColor) {
        ((TextView) (snackbar.getView().findViewById(R.id.snackbar_text))).setTextColor(messageColor);
    }
}
