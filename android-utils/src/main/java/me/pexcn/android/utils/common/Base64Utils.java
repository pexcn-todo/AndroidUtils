package me.pexcn.android.utils.common;

import android.util.Base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by pexcn on 2017-11-02.
 */
@SuppressWarnings("WeakerAccess")
public class Base64Utils {
    private Base64Utils() {
    }

    public static String encode(String plain) {
        return encode(plain, StandardCharsets.UTF_8);
    }

    public static String decode(String cipher) {
        return decode(cipher, StandardCharsets.UTF_8);
    }

    public static String encode(String plain, Charset charset) {
        return Base64.encodeToString(plain.getBytes(charset), Base64.DEFAULT);
    }

    public static String decode(String cipher, Charset charset) {
        return new String(Base64.decode(cipher, Base64.DEFAULT), charset);
    }
}
