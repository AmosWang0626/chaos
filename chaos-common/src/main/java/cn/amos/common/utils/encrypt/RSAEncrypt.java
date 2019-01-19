package cn.amos.common.utils.encrypt;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 *
 * @author IceWee
 * @version 1.0
 * @date 2012-4-26
 */
@Slf4j
public class RSAEncrypt {

    /**
     * 加密算法RSA
     */
    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE = 1024;
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";
    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥(字符串)
     */
    public static String encryptByPublicKey(String data, String publicKey)
            throws Exception {
        // 先对公钥解密,然后生成 PublicKey
        byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(x509KeySpec);
        // 数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        byte[] bytes = getBytes(data.getBytes(), cipher, MAX_ENCRYPT_BLOCK);
        return new String(Base64.getEncoder().encode(bytes));
    }

    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥(字符串)
     */
    public static String decryptByPrivateKey(String encryptedData, String privateKey) throws Exception {
        // 先对私钥解密,然后生成 PrivateKey
        byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        // 数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        byte[] bytes = getBytes(Base64.getDecoder().decode(encryptedData), cipher, MAX_DECRYPT_BLOCK);
        return new String(bytes);
    }

    private static byte[] getBytes(byte[] data, Cipher cipher, int maxEncryptBlock) throws Exception {
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > maxEncryptBlock) {
                cache = cipher.doFinal(data, offSet, maxEncryptBlock);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * maxEncryptBlock;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 生成密钥对(公钥和私钥)
     */
    private static Map<String, Key> genKeyPair() throws Exception {
        /* RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /* 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        /* 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEY_SIZE, sr);
        KeyPair keyPair = kpg.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Key> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Key> stringObjectMap = genKeyPair();
        /* 得到公钥 */
        Key publicKey = stringObjectMap.get(PUBLIC_KEY);
        String pub = new String(Base64.getEncoder().encode(publicKey.getEncoded()), StandardCharsets.UTF_8);
        /* 得到私钥 */
        Key privateKey = stringObjectMap.get(PRIVATE_KEY);
        String pri = new String(Base64.getEncoder().encode(privateKey.getEncoded()), StandardCharsets.UTF_8);

        System.out.println(pub);
        System.out.println(pri);
    }
}


