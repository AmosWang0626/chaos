package cn.amos.common.utils.other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/1/27
 */
public class J8DateUtil {

    /**
     * 格式化的日期
     * 例如: 2019-01-27 15:30:00
     */
    public static final DateTimeFormatter ISO_DATE_TIME_SIMPLE;

    static {
        ISO_DATE_TIME_SIMPLE = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .appendValue(ChronoField.HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
                .toFormatter();
    }

    public static void main(String[] args) {
        System.out.println(ISO_DATE_TIME_SIMPLE.format(LocalDateTime.now()));

        // 默认smart日期
        LocalDateTime localDateTime = LocalDateTime.parse("2019-02-31 23:59:59", ISO_DATE_TIME_SIMPLE);
        System.out.println(localDateTime.toString());
    }

}
