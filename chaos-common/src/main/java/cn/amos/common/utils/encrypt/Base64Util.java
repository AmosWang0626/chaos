package cn.amos.common.utils.encrypt;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

/**
 * PROJECT: chaos
 * DESCRIPTION: byte[] <---> string
 *
 * @author wangdaoyuan
 * @date 2018/8/30
 */
public class Base64Util {

    /**
     * decode string 2 byte
     *
     * @param str String
     * @return byte[]
     */
    public static byte[] decode(String str) {
        return new Base64().decode(str);
    }

    /**
     * decode string 2 byte 2 string
     *
     * @param str String
     * @return byte[]
     */
    public static String decodeToString(String str) {
        return new String(new Base64().decode(str), StandardCharsets.UTF_8);
    }

    /**
     * encode byte 2 string
     *
     * @param bytes byte[]
     * @return string
     */
    public static String encode(byte[] bytes) {
        return new Base64().encodeToString(bytes);
    }

    /**
     * encode byte 2 string
     *
     * @param str string
     * @return string
     */
    public static String encodeString(String str) {
        return new Base64().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        String str = "666···~~~测试一下？@！……；‘’“”:''???|||";

        System.out.println(str = encodeString(str));
        System.out.println(decodeToString(str));
    }

}
