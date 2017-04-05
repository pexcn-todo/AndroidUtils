package me.pexcn.android.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import me.pexcn.android.utils.thread.executors.AndroidThreadExecutor;

/**
 * Created by pexcn on 2016-09-20.
 */
@SuppressWarnings("unused")
public class ThreadExecutor {
    private final Executor executor;

    public ThreadExecutor() {
        executor = getExecutor();
    }

    /**
     * 尝试获取 UI 线程的线程池
     * 如果获取不到则会创建一个普通的 Java 线程池
     *
     * @return Executor 对象
     */
    private static Executor getExecutor() {
        try {
            return new AndroidThreadExecutor();
        } catch (Exception ignored) {
        }
        return Executors.newCachedThreadPool();
    }
}
