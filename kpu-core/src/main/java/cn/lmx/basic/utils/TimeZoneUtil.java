package cn.lmx.basic.utils;

import java.time.*;
import java.util.Date;
import java.util.Objects;

/**
 * 通用时间类型时区转换工具
 *
 * 支持 LocalDateTime、LocalDate、LocalTime、Date 之间的相互转换与时区切换
 */
public class TimeZoneUtil {

    /**
     * LocalDateTime 时区转换（保持时间点不变）
     */
    public static LocalDateTime convert(LocalDateTime localDateTime, ZoneId fromZone, ZoneId toZone) {
        Objects.requireNonNull(localDateTime, "localDateTime 不能为空");
        Objects.requireNonNull(fromZone, "fromZone 不能为空");
        Objects.requireNonNull(toZone, "toZone 不能为空");

        return localDateTime.atZone(fromZone)
                .withZoneSameInstant(toZone)
                .toLocalDateTime();
    }

    /**
     * LocalDate 时区转换（保持时间点不变）
     */
    public static LocalDate convert(LocalDate localDate, ZoneId fromZone, ZoneId toZone) {
        Objects.requireNonNull(localDate, "localDate 不能为空");
        Objects.requireNonNull(fromZone, "fromZone 不能为空");
        Objects.requireNonNull(toZone, "toZone 不能为空");

        // 将 LocalDate 转为 LocalDateTime（当天0点），再转换回目标时区的 LocalDate
        LocalDateTime ldt = localDate.atStartOfDay();
        return convert(ldt, fromZone, toZone).toLocalDate();
    }

    /**
     * LocalTime 时区转换（保持时间点不变）
     */
    public static LocalTime convert(LocalTime localTime, ZoneId fromZone, ZoneId toZone, LocalDate baseDate) {
        Objects.requireNonNull(localTime, "localTime 不能为空");
        Objects.requireNonNull(fromZone, "fromZone 不能为空");
        Objects.requireNonNull(toZone, "toZone 不能为空");

        // 需要一个日期基准，否则 LocalTime 无法确定时间点
        if (baseDate == null) baseDate = LocalDate.now(fromZone);
        LocalDateTime ldt = LocalDateTime.of(baseDate, localTime);
        return convert(ldt, fromZone, toZone).toLocalTime();
    }

    /**
     * Date -> LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date, ZoneId zone) {
        Objects.requireNonNull(date, "date 不能为空");
        Objects.requireNonNull(zone, "zone 不能为空");

        return date.toInstant().atZone(zone).toLocalDateTime();
    }

    /**
     * LocalDateTime -> Date
     */
    public static Date toDate(LocalDateTime localDateTime, ZoneId zone) {
        Objects.requireNonNull(localDateTime, "localDateTime 不能为空");
        Objects.requireNonNull(zone, "zone 不能为空");

        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * Date 时区转换（保持时间点不变）
     */
    public static Date convert(Date date, ZoneId fromZone, ZoneId toZone) {
        LocalDateTime ldt = toLocalDateTime(date, fromZone);
        LocalDateTime converted = convert(ldt, fromZone, toZone);
        return toDate(converted, toZone);
    }

    /**
     * 获取系统默认时区
     */
    public static ZoneId systemZone() {
        return ZoneId.systemDefault();
    }

    /**
     * 获取 UTC 时区
     */
    public static ZoneId utcZone() {
        return ZoneId.of("UTC");
    }
}
