package cn.lmx.basic.converter;

import org.springframework.core.convert.converter.Converter;
import cn.lmx.basic.utils.DateUtils;

import java.time.LocalDate;

/**
 * 解决 @RequestParam 标记的 LocalDate 类型的入参，参数转换问题。
 * <p>
 * yyyy-MM-dd
 * yyyy/MM/dd
 * yyyy年MM月dd日
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class String2LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        return DateUtils.parseAsLocalDate(source);
    }

}

