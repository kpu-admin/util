package cn.lmx.basic.scan.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.lmx.basic.base.R;
import cn.lmx.basic.scan.model.SystemApiVO;
import cn.lmx.basic.scan.properties.ScanProperties;
import cn.lmx.basic.scan.utils.RequestMappingScanUtils;

import java.util.List;
import java.util.Map;

/**
 * 系统api扫描
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
@RestController
@Slf4j
@RequestMapping("/anyone/systemApiScan")
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = ScanProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class SystemApiScanController {

    private final RequestMappingScanUtils requestMappingScanUtils;

    /**
     * 手动扫描
     *
     * @return 查询结果
     */
    @Operation(summary = "查询服务的所有API接口", description = "查询服务的所有API接口")
    @GetMapping
    public R<Map<String, List<SystemApiVO>>> scan() {
        return R.success(requestMappingScanUtils.getRequestMappingMap());
    }


}
