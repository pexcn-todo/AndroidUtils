package me.pexcn.android.utils.samples;

import android.app.Application;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-04-18.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
