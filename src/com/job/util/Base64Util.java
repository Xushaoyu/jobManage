package com.job.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Base64Util {
    /***
     * BASE64解密
     */
    public static String decryBASE64(String key) throws IOException {
        return new String((new BASE64Decoder()).decodeBuffer(key), StandardCharsets.UTF_8);
    }
    /***
     * BASE64加密
     */
    public static String encryptBASE64(String key){
        return (new BASE64Encoder()).encode(key.getBytes());
    }
}
