package cn.amos.common.utils.other;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * PROJECT: chaos <br>
 * DESCRIPTION: byte[] <---> string
 *
 * @author wangdaoyuan
 * @date 2018/8/30
 */
public class Base64Util {

    /**
     * string --> base64解码 ---> byte
     *
     * @param str 字符串
     * @return byte[]
     */
    public static byte[] decode(String str) {

        try {
            return new BASE64Decoder().decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * byte --> base64编码 ---> string
     *
     * @param bytes byte[]
     * @return string
     */
    public static String encode(byte[] bytes) {

        return new BASE64Encoder().encode(bytes);
    }

}
