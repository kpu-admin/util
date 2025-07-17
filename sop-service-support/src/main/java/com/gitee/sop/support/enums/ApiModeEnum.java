package com.gitee.sop.support.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 六如
 */
@Getter
@AllArgsConstructor
public enum ApiModeEnum {

    OPEN(1, "Open模式"),
    RESTFUL(2, "Restful模式");

    private final Integer value;

    private final String description;
}
