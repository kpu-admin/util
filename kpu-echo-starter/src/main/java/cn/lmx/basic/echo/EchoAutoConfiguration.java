package cn.lmx.basic.echo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.lmx.basic.echo.aspect.EchoResultAspect;
import cn.lmx.basic.echo.core.EchoServiceImpl;
import cn.lmx.basic.echo.properties.EchoProperties;
import cn.lmx.basic.interfaces.echo.EchoService;
import cn.lmx.basic.interfaces.echo.LoadService;

import java.util.Map;

/**
 * 关联字段数据注入工具 自动配置类
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Slf4j
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(EchoProperties.class)
public class EchoAutoConfiguration {
    private final EchoProperties echoProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = EchoProperties.PREFIX, name = "aop-enabled", havingValue = "true", matchIfMissing = true)
    public EchoResultAspect getEchoResultAspect(EchoService echoService) {
        return new EchoResultAspect(echoService);
    }

    /**
     * 回显服务
     * <p>
     * <p>
     * 在项目启动时，Spring会自动将实现了 LoadService 且被 Spring 扫描到容器中的实现类装载到strategyMap中。
     * <p>
     * 不理解的 strategyMap 为啥会自动装载的，自行百度：Spring 策略模式 和 Spring 自动注入的几种方式(@Autowired、set方法、构造器注入等)
     *
     * @param strategyMap 回显查询实例
     * @return cn.lmx.basic.echo.core.EchoService
     * @date 2025-01-01 00:00
     * @create [2025-01-01 00:00 ] [lmx] [初始创建]
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = EchoProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
    public EchoService getEchoService(Map<String, LoadService> strategyMap) {
        return new EchoServiceImpl(echoProperties, strategyMap);
    }
}

