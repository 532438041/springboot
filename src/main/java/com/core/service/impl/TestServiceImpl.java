package com.core.service.impl;

import com.core.base.result.PageResult;
import com.core.dao.mapper.TestMapper;
import com.core.entity.Test;
import com.core.service.TestService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author smallTao.liu
 * @date 2018/6/14 16:03
 * @version V1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getTest(String uid) {
        return testMapper.selectByPrimaryKey(uid);
    }

    @Override
    public PageResult<Test> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageResult(testMapper.getTestList());
    }
}
