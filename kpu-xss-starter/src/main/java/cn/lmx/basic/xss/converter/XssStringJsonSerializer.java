package cn.lmx.basic.xss.converter;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import cn.lmx.basic.xss.utils.XssUtils;

/**
 * 基于xss的 json 序列化器
 * 在本项目中，没有使用该类
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Slf4j
public class XssStringJsonSerializer extends JsonSerializer<String> {
    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) {
        if (StrUtil.isEmpty(value)) {
            return;
        }
        try {
            String encodedValue = XssUtils.xssClean(value, null);
            jsonGenerator.writeString(encodedValue);
        } catch (Exception e) {
            log.error("序列化失败:[{}]", value, e);
        }
    }

}
