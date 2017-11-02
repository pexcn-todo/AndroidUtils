package me.pexcn.android.utils.ui;

import android.annotation.SuppressLint;
import android.support.annotation.StringRes;
import android.widget.Toast;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-11-02.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
@SuppressLint("ShowToast")
public class ToastUtils {
    private static Toast sToast;

    private ToastUtils() {
    }

    public static void show(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    public static void show(@StringRes int resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    public static void show(String text, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(Utils.getContext(), text, duration);
        } else {
            if (sToast.getView().isShown()) {
                cancel();
                show(text, duration);
            }
            sToast.setText(text);
            sToast.setDuration(duration);
        }
        sToast.show();
    }

    public static void show(@StringRes int resId, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(Utils.getContext(), resId, duration);
        } else {
            if (sToast.getView().isShown()) {
                cancel();
                show(resId, duration);
            }
            sToast.setText(resId);
            sToast.setDuration(duration);
        }
        sToast.show();
    }

    public static void cancel() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}
