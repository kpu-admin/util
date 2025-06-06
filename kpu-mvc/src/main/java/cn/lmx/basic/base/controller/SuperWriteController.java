package cn.lmx.basic.base.controller;

import cn.lmx.basic.base.entity.SuperEntity;
import cn.lmx.basic.base.service.SuperService;

import java.io.Serializable;


/**
 * SuperReadController
 * <p>
 * 继承该类，就拥有了如下方法：
 * 1，save 保存，并支持子类扩展方法：handlerSave
 * 2，update 修改，并支持子类扩展方法：handlerUpdate
 * 3，delete 删除，并支持子类扩展方法：handlerDelete
 * <p>
 * 若重写扩展方法无法满足，则可以重写page、save等方法，但切记不要修改 @RequestMapping 参数
 *
 * @param <S>      Service
 * @param <Id>     主键
 * @param <Entity> 实体
 * @author lmx
 * @date 2025-01-01 00:00
 */
public abstract class SuperWriteController<S extends SuperService<Id, Entity>, Id extends Serializable, Entity extends SuperEntity<Id>, SaveVO, UpdateVO>
        extends SuperSimpleController<S, Id, Entity>
        implements SaveController<Id, Entity, SaveVO>,
        UpdateController<Id, Entity, UpdateVO>,
        DeleteController<Id, Entity> {

}
