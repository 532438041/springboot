package com.core.dao.repository;

import com.core.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description TODO
 * @author smallTao.liu
 * @date 2018/6/19 17:31
 * @version V1.0
 */
public interface SysLogRepository extends JpaRepository<SysLog, String> {
}
