package me.pexcn.android.utils.thread.executors;

import android.support.annotation.NonNull;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 一个 Android UI 线程的 Executor 实现
 * Developer by @aa65535 https://github.com/aa65535/okhttputils/blob/f906431/src/main/java/utils/okhttp/utils/ThreadExecutor.java#L31-L55
 * <p>
 * Created by pexcn on 2016-09-20.
 */
@SuppressWarnings("unused")
public class AndroidThreadExecutor implements Executor {
    private final Object handler;
    private final Method postMethod;

    public AndroidThreadExecutor() throws Exception {
        final Class<?> looperClass = Class.forName("android.os.Looper");
        final Class<?> handlerClass = Class.forName("android.os.Handler");
        handler = handlerClass.getConstructor(looperClass).newInstance(looperClass.getDeclaredMethod("getMainLooper").invoke(null));
        postMethod = handlerClass.getDeclaredMethod("post", Runnable.class);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        try {
            postMethod.invoke(handler, command);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
