package me.pexcn.android.utils.widget;

import android.support.annotation.ColorInt;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import me.pexcn.android.utils.R;

/**
 * Created by pexcn on 2016-09-21.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class SnackbarWrapper {
    private Snackbar mSnackbar;

    private SnackbarWrapper(Snackbar snackbar) {
        this.mSnackbar = snackbar;
    }

    /**
     * 从 Snackbar 获得一个 SnackbarWrapper 对象
     *
     * @param snackbar Snackbar 对象
     * @return SnackbarWrapper 对象
     */
    public static SnackbarWrapper from(Snackbar snackbar) {
        return new SnackbarWrapper(snackbar);
    }

    /**
     * 设置 Snackbar 的背景颜色
     *
     * @param backgroundColor 颜色值
     * @return SnackbarWrapper 对象
     */
    public SnackbarWrapper setBackgroundColor(@ColorInt int backgroundColor) {
        mSnackbar.getView().setBackgroundColor(backgroundColor);
        return this;
    }

    /**
     * 设置 Snackbar 的文字颜色
     *
     * @param messageColor 颜色值
     * @return SnackbarWrapper 对象
     */
    public SnackbarWrapper setMessageColor(@ColorInt int messageColor) {
        ((TextView) (mSnackbar.getView().findViewById(R.id.snackbar_text))).setTextColor(messageColor);
        return this;
    }

    /**
     * 显示 Snackbar
     */
    public void show() {
        mSnackbar.show();
    }
}
