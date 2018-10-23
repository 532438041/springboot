package com.core.service;

import com.core.base.result.PageResult;
import com.core.entity.Test;

/**
 * @description TODO
 * @author smallTao.liu
 * @date 2018/6/14 16:02
 * @version V1.0
 */
public interface TestService {

    /**
     *
     * @param uid
     * @return
     */
    Test getTest(String uid);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult<Test> getList(int pageNum, int pageSize);
}
