package cn.amos.common.utils.encrypt;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加密，对称加密算法，知道秘钥可以解密密文；
 * 密钥至少为8位字符，56位的密钥以及附加的 8位奇偶校验位，每组的第8位作为奇偶校验位；
 */
public class DESEncryptionUtil {

    private String desKey;

    public String getDesKey() {
        return desKey;
    }

    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }

    public String encrypt(String sourceText) {
        return encrypt(sourceText, desKey);
    }

    public String decrypt(String cipherText) {
        return decrypt(cipherText, desKey);
    }

    public static String encrypt(String sourceText, String keyString) {
        if (sourceText == null || sourceText.length() == 0) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建一个DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 生产密钥
            SecretKey key = keyFactory.generateSecret(dks);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 使用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            byte[] data = sourceText.getBytes();
            // 加密
            byte[] encryptedData = cipher.doFinal(data);
            // 转成16进制串
            return HexString.bytes2HexStr(encryptedData);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText, String keyString) {
        if (cipherText == null || cipherText.length() == 0) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密钥数据创建一个DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(dks);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 使用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 将十六进制串转成字节数组
            byte[] data = HexString.hex2Byte(cipherText);
            // 解密
            byte[] decryptedData = cipher.doFinal(data);

            return new String(decryptedData);
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | InvalidKeySpecException | IllegalBlockSizeException
                | NoSuchPaddingException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decrypt(
                encrypt("1231", "12345678abcqwe123"), "12345678abcqwe123"));
    }

}