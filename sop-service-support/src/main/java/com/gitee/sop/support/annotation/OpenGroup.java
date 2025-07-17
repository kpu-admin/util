package com.gitee.sop.support.annotation;

import java.lang.annotation.*;

/**
 * Restful分组，加了这个注解才会被认为是Restful接口
 *
 * @author 六如
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenGroup {

    /**
     * 分组名称
     */
    String value();

}
