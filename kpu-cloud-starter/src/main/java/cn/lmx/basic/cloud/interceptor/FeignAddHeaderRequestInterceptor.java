package cn.lmx.basic.cloud.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.URLUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import cn.lmx.basic.context.ContextConstants;
import cn.lmx.basic.context.ContextUtil;
import cn.lmx.basic.utils.StrPool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * feign client 拦截器， 实现将 feign 调用方的 请求头封装到 被调用方的请求头
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@Slf4j
public class FeignAddHeaderRequestInterceptor implements RequestInterceptor {
    public static final List<String> HEADER_NAME_LIST = Arrays.asList(
            ContextConstants.APPLICATION_ID_KEY, ContextConstants.TOKEN_KEY,
            ContextConstants.CLIENT_KEY,
            ContextConstants.JWT_KEY_USER_ID,
            ContextConstants.JWT_KEY_EMPLOYEE_ID, ContextConstants.JWT_KEY_UUID,
            ContextConstants.PATH_HEADER, ContextConstants.CLIENT_ID_HEADER,
            ContextConstants.CURRENT_COMPANY_ID_HEADER,
            ContextConstants.CURRENT_TOP_COMPANY_ID_HEADER,
            ContextConstants.CURRENT_DEPT_ID_HEADER,
            ContextConstants.FEIGN,
            ContextConstants.TRACE_ID_HEADER,
            ContextConstants.GRAY_VERSION,
            ContextConstants.STOP,
            ContextConstants.PROCEED,
            ContextConstants.TRACE_ID_HEADER, "X-Real-IP", "x-forwarded-for"
    );

    public FeignAddHeaderRequestInterceptor() {
        super();
    }

    @Override
    public void apply(RequestTemplate template) {
        // 需要seata-all的依赖，若需使用seata，请房开以下代码
//        String xid = RootContext.getXID();
//        if (StrUtil.isNotEmpty(xid)) {
//            template.header(RootContext.KEY_XID, xid);
//        }

        template.header(ContextConstants.FEIGN, StrPool.TRUE);
        log.info("thread id ={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            Map<String, String> localMap = ContextUtil.getLocalMap();
            localMap.forEach((key, value) -> template.header(key, URLUtil.encode(value)));
            return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        if (request == null) {
            log.warn("path={}, 在FeignClient API接口未配置FeignConfiguration类， 故而无法在远程调用时获取请求头中的参数!", template.path());
            return;
        }
        // 传递请求头
        HEADER_NAME_LIST.forEach(headerName -> {
            String header = request.getHeader(headerName);
            template.header(headerName, ObjectUtil.isEmpty(header) ? URLUtil.encode(ContextUtil.get(headerName)) : header);
        });
    }
}
