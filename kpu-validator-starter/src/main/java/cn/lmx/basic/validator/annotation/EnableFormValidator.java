package cn.lmx.basic.validator.annotation;

import org.springframework.context.annotation.Import;
import cn.lmx.basic.validator.config.ValidatorConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在启动类上添加该注解来启动表单验证功能
 *
 * @author lmx
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidatorConfiguration.class)
public @interface EnableFormValidator {
}
