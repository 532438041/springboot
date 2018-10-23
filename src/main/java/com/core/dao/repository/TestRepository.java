package com.core.dao.repository;

import com.core.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description
 * @author smallTao.liu
 * @date 2018/6/14 9:28
 * @version V1.0
 */
public interface TestRepository extends JpaRepository<Test, String> {

    /**
     *
     * @param name
     * @return
     */
    List<Test> findByName(String name);

}
