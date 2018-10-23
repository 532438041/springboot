package com.core.dao.repository;

import com.core.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description TODO
 * @author smallTao.liu
 * @date 2018/6/19 17:31
 * @version V1.0
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

    /**
     *
     * @param roleUid
     * @return
     */
    List<RolePermission> findAllByRoleUid(String roleUid);

}
