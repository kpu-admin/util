package cn.lmx.basic.validator.mateconstraint.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import cn.lmx.basic.validator.mateconstraint.IConstraintConverter;
import cn.lmx.basic.validator.utils.ValidatorConstants;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 非空 转换器
 *
 * @author lmx
 * @date 2025-01-01 00:00
 */
public class NotNullConstraintConverter extends BaseConstraintConverter implements IConstraintConverter {


    @Override
    protected String getType(Class<? extends Annotation> type) {
        return ValidatorConstants.NOT_NULL;
    }

    @Override
    protected List<Class<? extends Annotation>> getSupport() {
        return Arrays.asList(NotNull.class, NotEmpty.class, NotBlank.class);
    }

    @Override
    protected List<String> getMethods() {
        return Collections.singletonList(ValidatorConstants.MESSAGE);
    }
}
