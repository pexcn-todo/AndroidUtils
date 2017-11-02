package me.pexcn.android.utils.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pexcn on 2016-09-26.
 */
@SuppressWarnings("unused")
public class MD5Utils {
    private MD5Utils() {
    }

    /**
     * 获得字符串的 MD5 值
     *
     * @param plain 字符串
     * @return MD5 值
     */
    public static String get(String plain) {
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] digest = md.digest(plain.getBytes("UTF-8"));
            return ByteUtils.bytes2Hex(digest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
