package com.cx.utils.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author ChengXing
 * @Date Created in 22:07 2021/12/6
 * @Description 20211110blog
 */
public class MD5Utils {
    public MD5Utils() {
    }

    public static String md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            return bytesToHex(md5.digest());
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String md5slat(String str){
        return MD5Utils.md5(MD5Utils.md5("kuangstudy"+str+"202102170318!!!"));
    }

    public static String bytesToHex(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);

        String hashtext;
        for(hashtext = bigInt.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
        }

        return hashtext;
    }

    public static void main(String[] args) {

        System.out.println(md5slat("123456"));


    }
}
