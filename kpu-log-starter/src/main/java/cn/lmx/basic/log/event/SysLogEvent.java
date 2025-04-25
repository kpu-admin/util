package cn.lmx.basic.log.event;


import org.springframework.context.ApplicationEvent;
import cn.lmx.basic.model.log.OptLogDTO;

/**
 * 系统日志事件
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(OptLogDTO source) {
        super(source);
    }
}
