package cn.lmx.basic.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import cn.lmx.basic.utils.StrPool;

/**
 * 缓存配置
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Slf4j
@EnableCaching
@Import({
        CaffeineAutoConfigure.class, RedisAutoConfigure.class
})
public class CacheAutoConfigure {

    /**
     * key 的生成
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(StrPool.COLON);
            sb.append(method.getName());
            for (Object obj : objects) {
                if (obj != null) {
                    sb.append(StrPool.COLON);
                    sb.append(obj);
                }
            }
            return sb.toString();
        };
    }

}
