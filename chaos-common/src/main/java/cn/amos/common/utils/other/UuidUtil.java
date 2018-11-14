package cn.amos.common.utils.other;

import cn.amos.common.utils.encrypt.RandomUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * PROJECT: chaos
 * @date 2017/11/9
 *
 * @author DaoYuanWang
 */
public class UuidUtil {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String idPre = "UP";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String formatDate = format.format(new Date());
        String salt = RandomUtil.generateUpperString(8);
        System.out.println(idPre + formatDate + salt);

        BigDecimal bigDecimal = new BigDecimal("10000.9");
        System.out.println(bigDecimal.toBigInteger());
    }
}
