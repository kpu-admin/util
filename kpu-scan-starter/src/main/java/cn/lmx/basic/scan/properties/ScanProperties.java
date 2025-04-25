package cn.lmx.basic.scan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import cn.lmx.basic.constant.Constants;

/**
 * 缓存配置
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Data
@ConfigurationProperties(prefix = ScanProperties.PREFIX)
public class ScanProperties {
    public static final String PREFIX = Constants.PROJECT_PREFIX + ".scan";

    /**
     * 是否启用
     */
    private Boolean enabled = true;

    /**
     * 扫描包路径
     */
    private String basePackage;
}
