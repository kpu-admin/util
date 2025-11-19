//package cn.lmx.basic.converter;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//
//import static cn.lmx.basic.context.TimeZoneContext.getZoneId;
//
//public class DynamicZoneLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
//    private final DateTimeFormatter formatter;
//
//    public DynamicZoneLocalDateTimeSerializer(DateTimeFormatter formatter) {
//        this.formatter = formatter;
//    }
//
//    @Override
//    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//        // 假设 LocalDateTime 原本是系统默认时区时间
//        ZonedDateTime zoned = value.atZone(ZoneId.systemDefault()).withZoneSameInstant(getZoneId());
//        gen.writeString(zoned.format(formatter));
//    }
//}
