package cn.lmx.basic.base.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cn.lmx.basic.annotation.log.WebLog;
import cn.lmx.basic.base.R;
import cn.lmx.basic.base.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;


/**
 * 删除Controller
 *
 * @param <Entity> 实体
 * @param <Id>     主键
 * @author lmx
 * @date 2025-01-01 00:00
 */
public interface DeleteController<Id extends Serializable, Entity extends SuperEntity<Id>>
        extends BaseController<Id, Entity> {

    /**
     * 删除方法
     *
     * @param ids id
     * @return 是否成功
     */
    @Operation(summary = "删除")
    @DeleteMapping
    @WebLog("'删除:' + #ids")
    default R<Boolean> delete(@RequestBody List<Id> ids) {
        R<Boolean> result = handlerDelete(ids);
        if (result.getDefExec()) {
            return R.success(getSuperService().removeByIds(ids));
        }
        return result;
    }

    /**
     * 自定义删除
     *
     * @param ids id
     * @return 返回SUCCESS_RESPONSE, 调用默认更新, 返回其他不调用默认更新
     */
    default R<Boolean> handlerDelete(List<Id> ids) {
        return R.successDef(true);
    }

}
