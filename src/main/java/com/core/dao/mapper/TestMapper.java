package com.core.dao.mapper;

import com.core.entity.Test;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/19 17:31
 */
//@Mapper 使用MapperScan统一配置
public interface TestMapper {

    /**
     *
     * @param uid
     * @return
     */
    Test selectByPrimaryKey(String uid);

    /**
     *
     * @param uid
     * @return
     */
    @Select("select * from role where uid=#{uid}")
    Test selectUid(String uid);

    /**
     *
     * @return
     */
    Page<Test> getTestList();
}