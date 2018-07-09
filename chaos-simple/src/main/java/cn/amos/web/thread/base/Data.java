package cn.amos.web.thread.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static void main(String[] args) {

        long date = new Date().getTime();
        System.out.println(date);
        testTimestamp(date);
    }

    // Test Timestamp 强大的数据库数据类型
    private static void testTimestamp(long date) {
        Timestamp timestamp = new Timestamp(date);

        System.out.println(getDetail(timestamp));
        System.out.println(getSimple(timestamp));
        System.out.println(getSimpleDate(timestamp));
        System.out.println(getSimpleTime(timestamp));
    }

    private static String getDetail(Timestamp timestamp) {
        // SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDate.format(timestamp);
    }

    private static String getSimple(Timestamp timestamp) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd HH:mm");
        return simpleDate.format(timestamp);
    }

    private static String getSimpleDate(Timestamp timestamp) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd");
        return simpleDate.format(timestamp);
    }

    private static String getSimpleTime(Timestamp timestamp) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
        return simpleDate.format(timestamp);
    }
}
