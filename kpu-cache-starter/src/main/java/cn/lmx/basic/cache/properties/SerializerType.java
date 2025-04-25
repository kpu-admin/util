package cn.lmx.basic.cache.properties;

/**
 * 序列化类型
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public enum SerializerType {
    /**
     * json 序列化
     */
    JACK_SON,
    /**
     * 默认:ProtoStuff 序列化
     */
    ProtoStuff,
    /**
     * jdk 序列化
     */
    JDK
}
