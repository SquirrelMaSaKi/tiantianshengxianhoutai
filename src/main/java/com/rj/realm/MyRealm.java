package com.rj.realm;

import com.rj.pojo.Admin;
import com.rj.service.AdminService;
import com.rj.service.PermService;
import com.rj.service.RoleService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

@Setter
public class MyRealm extends AuthorizingRealm {
    private AdminService adminService;
    private RoleService roleService;
    private PermService permService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roleNames = roleService.roleNames(username);
        Set<String> permNames = permService.permNames(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permNames);
        info.setRoles(roleNames);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Admin admin = adminService.findByUsernameOrEmail(username);
        if(admin == null){
            return null;
        }
        ByteSource bytes = ByteSource.Util.bytes(admin.getSalt());
        return new SimpleAuthenticationInfo(admin.getUsername(), admin.getPassword(), bytes, this.getName());
    }
}
