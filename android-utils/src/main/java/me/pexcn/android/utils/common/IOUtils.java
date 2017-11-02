package me.pexcn.android.utils.common;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by pexcn on 2016-09-26.
 */
@SuppressWarnings("unused")
public class IOUtils {
    private IOUtils() {
    }

    /**
     * 关闭一个可关闭的对象
     *
     * @param closeable 可关闭的对象
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
