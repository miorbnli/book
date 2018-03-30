package com.book.service.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.book.mapper.UserMapper;
import com.book.pojo.User;

public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 授权检测 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// 1.获取用户权限
		// 1.1获取用户信息
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		Long userId = user.getUserId();

		// 1.2获取资源访问权限
		List<String> permsList = new ArrayList<>();
		permsList = userMapper.findUserPermissions(userId);

		// 1.3取重复的权限
		HashSet<String> set = new HashSet<>();
		for (String perm : permsList) {
			if (perm != null && !("".equals(perm))) {
				set.add(perm);
			}
		}
		// 2.封装用户权限(AuthorizztionInfo)
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(set);// set方法封装权限或也可以用构造直接封装
		return info;
	}

	/**
	 * 认证检测(用户及密码的正确性)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.获取用户名
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		// 2.根据用户名查找用户对象
		User user = userMapper.findObjectByUserName(username);
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		// 3.初始化SimpleAuthenticationInfo对象
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), credentialsSalt,
				getName());
		// 4.存储用户信息
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		return info;
	}

}
