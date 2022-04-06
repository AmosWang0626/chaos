package com.amos.design.main;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 日期测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/4/6
 */
public class DateTests {

    @Test
    public void hours() {
        LocalDateTime begin = LocalDateTime.parse("2022-03-30T21:22:28");
        LocalDateTime end = LocalDateTime.parse("2022-04-06T17:33:41");

        long minutes = begin.until(end, ChronoUnit.MINUTES);
        System.out.println(minutes);

        int gcCount = 165;
        System.out.println(minutes / gcCount);
    }

}
