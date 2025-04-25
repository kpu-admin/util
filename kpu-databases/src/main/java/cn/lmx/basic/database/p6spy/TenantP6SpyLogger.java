package cn.lmx.basic.database.p6spy;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import cn.lmx.basic.context.ContextConstants;
import cn.lmx.basic.context.ContextUtil;

/**
 * 用于 p6spy 在输出的sql日志中，打印当前租户、当前用户ID、当前数据源连接url
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class TenantP6SpyLogger implements MessageFormattingStrategy {
    public static final String REGX = "\\s+";

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category,
                                String prepared, String sql, String url) {
        String msg = """
                线程参数：{}: {}
                消耗时间：{} ms, 执行时间 {}
                数据源: {}
                执行的SQL：{}
                """;
        return StringUtils.isNotBlank(sql) ?
                StrUtil.format(msg,
                        ContextConstants.USER_ID_HEADER, ContextUtil.getUserId(),
                        elapsed, now, url, sql.replaceAll(REGX, StringPool.SPACE)) :
                StringPool.EMPTY;
    }
}
