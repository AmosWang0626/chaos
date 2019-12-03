package cn.amos.common.utils.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * PROJECT: chaos
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

    /**
     * <p>Description:使用gzip进行解压缩</p>
     *
     * @param compressedStr ***
     * @return **
     */
    private static String gunZip(String compressedStr) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            // 对返回数据BASE64解码
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);
            // 解码后对数据gzip解压缩
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            // 最后对数据进行utf-8转码
            decompressed = out.toString("utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: " + Base64Util.class.getName() + " GUN_ZIP " + e.getMessage());
        }
        return decompressed;
    }

    public static void main(String[] args) {
        String str = "1433233";

        String gunZip = gunZip(str);
        System.out.println(gunZip);
    }

}
