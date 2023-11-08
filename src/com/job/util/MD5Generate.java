package com.job.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generate {
    /**
     * 生成MD5
     *
     * @param str 待加密字符串
     * @return  加密后字符串
     */
    public String encode(String str) throws NoSuchAlgorithmException {
        byte[] result;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(StandardCharsets.UTF_8));
        result = md.digest();
        return parseByte2HexStr(result);
    }

    /**
     * 将二进制转换成十六进制
     *
     * @param buf 待转换数据
     * @return 生成的十六进制数据
     */
    private String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
