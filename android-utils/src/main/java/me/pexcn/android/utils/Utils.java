package me.pexcn.android.utils;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by pexcn on 2016-09-20.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Utils {
    private static Utils sInstance;
    private static WeakReference<Application> sApp;

    private Utils(Application app) {
        sApp = new WeakReference<>(app);
    }

    /**
     * 初始化 Utils
     *
     * @param app Application 对象
     * @return Utils 实例
     */
    public static Utils init(Application app) {
        if (sInstance == null) {
            sInstance = new Utils(app);
        }
        return sInstance;
    }

    /**
     * 获得 Application 级别的 Context 对象
     *
     * @return Context 对象
     */
    public static Context getContext() {
        return sApp.get().getApplicationContext();
    }

    /**
     * 获取 Utils 对象
     *
     * @return Utils 对象
     */
    public static Utils getInstance() {
        return sInstance;
    }
}
