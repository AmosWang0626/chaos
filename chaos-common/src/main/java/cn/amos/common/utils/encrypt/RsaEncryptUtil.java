package cn.amos.common.utils.encrypt;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT: certificates
 * DESCRIPTION: rsa 加密/解密
 *
 * @author Daoyuan
 * @date 2019/1/16
 */
public class RsaEncryptUtil {

    /**
     * 指定key的大小
     */
    private static final int KEY_SIZE = 1024;
    /**
     * 指定加密算法为RSA
     */
    private static final String ALGORITHM = "RSA";

    /**
     * RSA加密方法
     */
    public static String encrypt(String source, String publicKey) throws Exception {
        Key key = generatePublicKey(publicKey);
        //得到Cipher对象来实现对源数据的RSA加密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64Utils.encodeToString(cipher.doFinal(source.getBytes()));
    }

    /**
     * RSA解密方法
     */
    public static String decrypt(String cryptoGraph, String privateKey) throws Exception {
        Key key = generatePrivateKey(privateKey);
        //对已经加密的数据进行RSA解密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] b1 = Base64Utils.decodeFromString(cryptoGraph);
        //执行解密操作
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    private static PublicKey generatePublicKey(String key) throws Exception {
        byte[] keyBytes = Base64Utils.decodeFromString(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey generatePrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64Utils.decodeFromString(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 生成密钥对
     */
    public static Map<String, String> generateKeyPair() throws Exception {
        /* RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /* 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
        /* 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEY_SIZE, sr);
        /* 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /* 得到公钥 */
        Key publicKey = kp.getPublic();
        byte[] publicKeyBytes = publicKey.getEncoded();
        String pub = new String(Base64Utils.encode(publicKeyBytes), StandardCharsets.UTF_8);
        /* 得到私钥 */
        Key privateKey = kp.getPrivate();
        byte[] privateKeyBytes = privateKey.getEncoded();
        String pri = new String(Base64Utils.encode(privateKeyBytes), StandardCharsets.UTF_8);

        Map<String, String> map = new HashMap<>(4);
        map.put("publicKey", pub);
        map.put("privateKey", pri);
        RSAPublicKey rsp = (RSAPublicKey) kp.getPublic();
        BigInteger bigInteger = rsp.getModulus();
        byte[] deBase64Value = Base64Utils.encode(bigInteger.toByteArray());
        String retValue = new String(deBase64Value);
        map.put("modulus", retValue);
        return map;
    }


    public static void main(String[] args) throws Exception {
        Map<String, String> map = generateKeyPair();
        String publicKey = map.get("publicKey");
        String privateKey = map.get("privateKey");
        System.out.println(map.get("modulus"));
        String source = "hello world!";
        String encrypt = encrypt(source, publicKey);
        String decrypt = decrypt(encrypt, privateKey);
        System.out.println(decrypt);
    }

}
