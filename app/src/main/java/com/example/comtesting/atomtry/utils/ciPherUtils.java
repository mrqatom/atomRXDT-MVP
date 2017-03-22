package com.example.comtesting.atomtry.utils;

import android.support.annotation.NonNull;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by atom on 2017/3/16.
 *
 */

public class ciPherUtils {
    /**
     * 进行MD5加密（小写）
     */
    public static String Str2MD5LowCase(@NonNull String str) {
        return Str2MD5UpCase(str).toLowerCase();
    }

    /**
     * 进行MD5加密MD5加密
     */
    public static String Str2MD5UpCase(@NonNull String str) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(
                    str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
