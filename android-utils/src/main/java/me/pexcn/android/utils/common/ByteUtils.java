package me.pexcn.android.utils.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by pexcn on 2016-09-27.
 */
@SuppressWarnings("unused")
public class ByteUtils {
    private final static char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * Byte 数组转十六进制字符串
     *
     * @param bytes Byte 数组
     * @return 十六进制字符串
     */
    public static String bytes2Hex(byte[] bytes) {
        final char[] chars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            chars[j * 2] = HEX[v >>> 4];
            chars[j * 2 + 1] = HEX[v & 0x0F];
        }
        return new String(chars);
    }

    /**
     * 字节数组转 Bitmap 对象
     *
     * @param bytes 字节数组
     * @return Bitmap 对象
     */
    public static Bitmap bytes2Bitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
