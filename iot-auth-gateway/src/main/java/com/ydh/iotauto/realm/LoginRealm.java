package com.ydh.iotauto.realm;


import com.ydh.iotauto.entity.User;
import com.ydh.iotauto.feign.IUserFeign;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginRealm extends AuthorizingRealm {
    @Autowired
    IUserFeign iUserFeign ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        if(primaryPrincipal.equals("shaoyadong")){
            System.out.println("进入到权限里头了");
        }


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = iUserFeign.getInfoByName(token.getUsername());
//        System.out.println("打印下密码");
//        System.out.println(token.getPassword());

        if (user!=null){
            return new SimpleAuthenticationInfo(user,user.getPasswd(), ByteSource.Util.bytes(user.getSalt()),this.getName()) ;

        }
        return null;
    }
}
