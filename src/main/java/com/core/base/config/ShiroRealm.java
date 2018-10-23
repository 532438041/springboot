package com.core.base.config;

import com.core.dao.repository.*;
import com.core.entity.RolePermission;
import com.core.entity.User;
import com.core.entity.UserRole;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/7/9 11:16
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 权限配置
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<UserRole> roleList = userRoleRepository.findAllByUserUid(user.getUid());
        for (UserRole role : roleList) {
            authorizationInfo.addRole(roleRepository.getOne(role.getRoleUid()).toString());
            List<RolePermission> permissionList = rolePermissionRepository.findAllByRoleUid(role.getRoleUid());
            for (RolePermission rolePermission : permissionList) {
                authorizationInfo.addStringPermission(permissionRepository.getOne(rolePermission.getPermissionUid()).toString());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String userName = (String) token.getPrincipal();

        User user = userRepository.findByUserName(userName);
        if (user == null || user.getStatus() == "0") {
            throw new UnknownAccountException();
        }
        if (user.getStatus() == "2") {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getUserPwd(), ByteSource.Util.bytes(user.getCredentialsSalt()), user.getDisplayName());
        return authenticationInfo;
    }
}
