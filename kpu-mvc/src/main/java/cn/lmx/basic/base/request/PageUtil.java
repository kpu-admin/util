package cn.lmx.basic.base.request;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.lmx.basic.database.mybatis.conditions.Wraps;
import cn.lmx.basic.utils.DateUtils;

import java.util.Map;

/**
 * 分页工具类
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class PageUtil {
    private PageUtil() {
    }

    /**
     * 重置时间区间参数
     *
     * @param params 分页参数
     */
    public static <T> void timeRange(PageParams<T> params) {
        if (params == null) {
            return;
        }
        Map<String, Object> extra = params.getExtra();
        if (MapUtil.isEmpty(extra)) {
            return;
        }
        for (Map.Entry<String, Object> field : extra.entrySet()) {
            String key = field.getKey();
            Object value = field.getValue();
            if (ObjectUtil.isEmpty(value)) {
                continue;
            }
            if (key.endsWith(Wraps.ST)) {
                extra.put(key, DateUtils.getStartTime(value.toString()));
            } else if (key.endsWith(Wraps.ED)) {
                extra.put(key, DateUtils.getEndTime(value.toString()));
            }
        }
    }
}
