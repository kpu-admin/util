package cn.lmx.basic.interfaces.echo;

import java.util.Map;

/**
 * 注入VO 父类
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public interface EchoVO {

    /**
     * 回显值 集合
     *
     * @return 回显值 集合
     */
    Map<String, Object> getEchoMap();
}
