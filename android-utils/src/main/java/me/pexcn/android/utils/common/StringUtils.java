package me.pexcn.android.utils.common;

/**
 * Created by pexcn on 2016-09-27.
 */
@SuppressWarnings("unused")
public class StringUtils {
    private final static char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * Byte 数组转十六进制字符串
     *
     * @param bytes Byte 数组
     * @return 十六进制字符串
     */
    public static String bytesToHex(byte[] bytes) {
        final char[] chars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            chars[j * 2] = HEX[v >>> 4];
            chars[j * 2 + 1] = HEX[v & 0x0F];
        }
        return new String(chars);
    }
}
