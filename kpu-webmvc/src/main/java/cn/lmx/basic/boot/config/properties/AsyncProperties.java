package cn.lmx.basic.boot.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import cn.lmx.basic.constant.Constants;

import static cn.lmx.basic.boot.config.properties.AsyncProperties.PREFIX;

/**
 * 异步线程配置
 *
 * @author lmx
 * @date 2025-01-01 00:00
 * @create [2025-01-01 00:00 ] [lmx] [初始创建]
 */
@Getter
@Setter
@ConfigurationProperties(PREFIX)
public class AsyncProperties {
    public static final String PREFIX = Constants.PROJECT_PREFIX + ".async";
    private boolean enabled = true;
    /**
     * 异步核心线程数，默认：2
     */
    private int corePoolSize = 2;
    /**
     * 异步最大线程数，默认：50
     */
    private int maxPoolSize = 50;
    /**
     * 队列容量，默认：10000
     */
    private int queueCapacity = 10000;
    /**
     * 线程存活时间，默认：300
     */
    private int keepAliveSeconds = 300;
    /**
     * 线程名前缀
     */
    private String threadNamePrefix = "kpu-async-executor-";
}
