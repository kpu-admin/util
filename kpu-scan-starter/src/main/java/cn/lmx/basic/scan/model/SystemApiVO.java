package cn.lmx.basic.scan.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Data
@Builder
@ToString
public class SystemApiVO {

    /**
     * 接口名称
     */
    private String name;
    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 请求路径
     */
    private String uri;

    /**
     * 服务ID
     */
    private String springApplicationName;

    /**
     * 类名
     */
    private String controller;
}
