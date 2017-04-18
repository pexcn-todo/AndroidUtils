package me.pexcn.android.utils.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by pexcn on 2017-04-18.
 */
public class BitmapUtils {
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public static Bitmap bytes2Bitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
