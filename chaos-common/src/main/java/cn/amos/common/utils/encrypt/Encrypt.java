package cn.amos.common.utils.encrypt;

/**
 * PROJECT: chaos
 * @date 2017/10/16
 * @author DaoYuanWang
 */
public class Encrypt {

    private static final String PHONE_NO = "18937128861";

    public static void main(String[] args) {
        String pushKey = "PUSH_KEY_" + PHONE_NO;
        // 密码盐
        Long salt = System.currentTimeMillis();
        System.out.println("当前时间戳[密码盐]\t" + salt);
        String encryptValue = MD5EncryptionUtil.encrypt(PHONE_NO + salt);

        System.out.println("加密后的key：" + encryptValue);

        // 封装实体类
        PushKeyEntity pushKeyEntity = new PushKeyEntity();
        pushKeyEntity.setPhoneNo(PHONE_NO);
        pushKeyEntity.setSalt(String.valueOf(salt));
        pushKeyEntity.setPushKey(encryptValue);

        // 存储入 redis
        /*new RedisUtil().set(pushKey, pushKeyEntity);*/
        // 从redis获取
        /*pushKeyEntity = new Gson().fromJson(new RedisUtil().get(pushKey), PushKeyEntity.class);*/

        // 解密
        String decryptValue = MD5EncryptionUtil.decrypt(PHONE_NO + pushKeyEntity.getSalt()).substring(0, 11);

        System.out.println("解密并截取获得手机号：" + decryptValue);
    }

}
