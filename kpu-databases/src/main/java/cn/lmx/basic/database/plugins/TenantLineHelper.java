package cn.lmx.basic.database.plugins;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lmx
 * @version v1.0.0
 * @date 2025-01-01 00:00
 */
public class TenantLineHelper {
    final static Map<String, Boolean> CACHE = new ConcurrentHashMap<>();

    /**
     * 判断 mapper id 是否启用了 @TenantLine 注解
     *
     * @param id mapper 唯一
     * @author lmx
     * @date 2025-01-01 00:00
     * @create [2025-01-01 00:00 ] [lmx] [初始创建]
     */
    public static boolean willTenantLine(String id) {
        Boolean cache = CACHE.get(id);
        if (cache == null) {
            cache = CACHE.get(id.substring(0, id.lastIndexOf(StringPool.DOT)));
        }
        if (cache != null) {
            return cache;
        }
        return false;
    }

}
