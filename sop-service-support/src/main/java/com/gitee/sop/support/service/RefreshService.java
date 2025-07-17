package com.gitee.sop.support.service;

import java.util.List;

/**
 * @author 六如
 */
public interface RefreshService {

    /**
     * 刷新api信息
     *
     * @param apiIds
     */
    void refreshApi(List<Long> apiIds);

    /**
     * 刷新isv
     *
     * @param appIds
     */
    void refreshIsv(List<String> appIds);

    /**
     * 刷新isv接口权限
     *
     * @param isvIds
     */
    void refreshIsvPerm(List<Long> isvIds);

    /**
     * 刷新secret
     *
     * @param isvIds
     */
    void refreshSecret(List<Long> isvIds);
}
