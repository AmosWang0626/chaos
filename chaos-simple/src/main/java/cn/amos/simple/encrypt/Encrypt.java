package cn.amos.encrypt;

import cn.amos.redis.RedisUtil;
import com.google.gson.Gson;

/**
 * @project: demo-java
 * @date: 2017/10/16
 * @author: DaoYuanWang
 */
public class Encrypt {

    private static Gson gson = new Gson();

    private static String phoneNo = "18937128861";

    public static void main(String[] args) {
        String pushKey = "PUSH_KEY_" + phoneNo;
        // 密码盐
        Long salt = System.currentTimeMillis();
        System.out.println("当前时间戳[密码盐]\t" + salt);
        String encryptValue = MD5EncryptionUtil.encrypt(phoneNo + salt);

        System.out.println("加密后的key：" + encryptValue);

        // 封装实体类
        PushKeyEntity pushKeyEntity = new PushKeyEntity();
        pushKeyEntity.setPhoneNo(phoneNo);
        pushKeyEntity.setSalt(String.valueOf(salt));
        pushKeyEntity.setPushKey(encryptValue);

        // 插入redis
        new RedisUtil().set(pushKey, pushKeyEntity);

        // 从redis获取
        pushKeyEntity = gson.fromJson(new RedisUtil().get(pushKey), PushKeyEntity.class);

        // 解密
        String decryptValue = MD5EncryptionUtil.decrypt(phoneNo + pushKeyEntity.getSalt()).substring(0, 11);

        System.out.println("解密并截取获得手机号：" + decryptValue);
    }

}
