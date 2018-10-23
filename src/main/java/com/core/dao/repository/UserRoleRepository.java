package com.core.dao.repository;

import com.core.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description TODO
 * @date 2018/6/19 17:31
 */
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

    /**
     *
     * @param userUid
     * @return
     */
    List<UserRole> findAllByUserUid(String userUid);

}
