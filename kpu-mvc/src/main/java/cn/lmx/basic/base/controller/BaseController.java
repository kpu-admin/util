package cn.lmx.basic.base.controller;

import cn.lmx.basic.base.R;
import cn.lmx.basic.base.entity.SuperEntity;
import cn.lmx.basic.base.service.SuperService;
import cn.lmx.basic.context.ContextUtil;
import cn.lmx.basic.exception.BizException;
import cn.lmx.basic.exception.code.BaseExceptionCode;

import java.io.Serializable;

/**
 * 基础接口
 *
 * @param <Entity> 实体
 * @author lmx
 * @date 2025-01-01 00:00
 */
public interface BaseController<Id extends Serializable, Entity extends SuperEntity<Id>> {

    /**
     * 获取Service
     *
     * @return Service
     */
    SuperService<Id, Entity> getSuperService();

    /**
     * 获取实体的类型
     *
     * @return 实体的类型
     */
    Class<Entity> getEntityClass();

    /**
     * 成功返回
     *
     * @param data 返回内容
     * @param <T>  返回类型
     * @return R 成功
     */
    default <T> R<T> success(T data) {
        return R.success(data);
    }

    /**
     * 成功返回
     *
     * @return R.true
     */
    default R<Boolean> success() {
        return R.success();
    }

    /**
     * 失败返回
     *
     * @param msg 失败消息
     * @param <T> 返回类型
     * @return 失败
     */
    default <T> R<T> fail(String msg) {
        return R.fail(msg);
    }

    /**
     * 失败返回
     *
     * @param msg  失败消息
     * @param args 动态参数
     * @param <T>  返回类型
     * @return 失败
     */
    default <T> R<T> fail(String msg, Object... args) {
        return R.fail(msg, args);
    }

    /**
     * 失败返回
     *
     * @param code 失败编码
     * @param msg  失败消息
     * @param <T>  返回类型
     * @return 失败
     */
    default <T> R<T> fail(int code, String msg) {
        return R.fail(code, msg);
    }

    /**
     * 失败返回
     *
     * @param exceptionCode 失败异常码
     * @return 失败
     */
    default <T> R<T> fail(BaseExceptionCode exceptionCode) {
        return R.fail(exceptionCode);
    }

    /**
     * 失败返回
     *
     * @param exception 异常
     * @return 失败
     */
    default <T> R<T> fail(BizException exception) {
        return R.fail(exception);
    }

    /**
     * 失败返回
     *
     * @param throwable 异常
     * @return 失败
     */
    default <T> R<T> fail(Throwable throwable) {
        return R.fail(throwable);
    }

    /**
     * 参数校验失败返回
     *
     * @param msg 错误消息
     * @return 失败
     */
    default <T> R<T> validFail(String msg) {
        return R.validFail(msg);
    }

    /**
     * 参数校验失败返回
     *
     * @param msg  错误消息
     * @param args 错误参数
     * @return 失败
     */
    default <T> R<T> validFail(String msg, Object... args) {
        return R.validFail(msg, args);
    }

    /**
     * 参数校验失败返回
     *
     * @param exceptionCode 错误编码
     * @return 失败
     */
    default <T> R<T> validFail(BaseExceptionCode exceptionCode) {
        return R.validFail(exceptionCode);
    }

    /**
     * 获取当前id
     *
     * @return userId
     */
    default Long getUserId() {
        return ContextUtil.getUserId();
    }


}
