package cn.amos.simple.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompare {

    private static Calendar calendar = Calendar.getInstance();

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
//        Date testDate = null;
//        try {
//            testDate = sdf.parse("2017-9-17");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date testDay = getTestDay(testDate, -6);
//        System.out.println(testDate.getTime());
//        System.out.println(sdf.format(testDate));
//        System.out.println(sdf.format(testDay));

        calendar.add(Calendar.HOUR_OF_DAY, -2);
        Date time = calendar.getTime();
        System.out.println(sdf.format(time));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));



        // 超过五分钟的认证中,重新执行任务
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);
//        long timeInMillis = calendar.getTimeInMillis();
//        long currentTimeMillis = System.currentTimeMillis();
        time = calendar.getTime();
        System.out.println(sdf.format(time));

//        System.out.println("SSS:" + (currentTimeMillis - timeInMillis) / (1000 * 60));

    }

    private static void getYMD() {
        calendar.setTime(new Date());
        String year = calendar.get(Calendar.YEAR) + "";
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + month + "月" + day + "日");
    }

    private static Date getPreDay(Date date) {
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    private static Date getTestDay(Date date, int i) {
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, i);
        return calendar.getTime();
    }
}
