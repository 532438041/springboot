package com.core.dao.repository;

import com.core.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description TODO
 * @author smallTao.liu
 * @date 2018/6/19 17:31
 * @version V1.0
 */
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
