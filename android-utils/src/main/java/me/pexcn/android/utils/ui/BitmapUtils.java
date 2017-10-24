package me.pexcn.android.utils.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-10-24.
 */
public class BitmapUtils {
    private BitmapUtils(){}

    /**
     * 从 Uri 获取 Bitmap
     *
     * @return Bitmap 对象
     */
    public static Bitmap getBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(Utils.getContext().getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Bitmap 对象转字节数组
     *
     * @param bitmap Bitmap 对象
     * @return 字节数组
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
