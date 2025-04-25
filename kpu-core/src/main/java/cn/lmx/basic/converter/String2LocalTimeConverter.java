package cn.lmx.basic.converter;

import org.springframework.core.convert.converter.Converter;
import cn.lmx.basic.utils.DateUtils;

import java.time.LocalTime;

/**
 * 解决 @RequestParam LocalTime Date 类型的入参，参数转换问题。
 * <p>
 * HH:mm:ss
 * HH时mm分ss秒
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class String2LocalTimeConverter implements Converter<String, LocalTime> {
    @Override
    public LocalTime convert(String source) {
        return DateUtils.parseAsLocalTime(source);
    }
}
