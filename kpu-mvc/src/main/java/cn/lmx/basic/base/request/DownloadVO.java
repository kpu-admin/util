package cn.lmx.basic.base.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author lmx
 * @version v1.0.0
 * @date 2025-01-01 00:00
 */
@Data
@Builder
public class DownloadVO {
    byte[] data;
    String fileName;
}
