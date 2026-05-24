package com.jiazhong.huojian.spring.boot.example.shopping.util;

import lombok.SneakyThrows;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5UtilHandler {
    @SneakyThrows
    public static String encryptMD5(String input) {
        try {
            // 创建MD5加密对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 执⾏加密操作
            byte[] messageDigest = md.digest(input.getBytes());
            // 将字节数组转换为16进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // 返回加密后的字符串
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
