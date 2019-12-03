package cn.amos.common.utils.encrypt;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @date 2017/10/16
 */
public class EncryptMain {

    private static final String PHONE_NO = "18937128861";

    public static void main(String[] args) {
        // 密码盐
        Long salt = System.currentTimeMillis();
        String encryptValue = Md5Utils.encrypt(PHONE_NO + salt);
        System.out.println("加密后的key：" + encryptValue);

        // 解密
        String decryptValue = Md5Utils.decrypt(PHONE_NO + salt);
        System.out.println("解密并截取获得手机号：" + decryptValue.substring(0, 11));
    }

}
