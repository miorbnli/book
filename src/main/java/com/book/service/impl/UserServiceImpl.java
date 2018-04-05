package com.book.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.book.common.exception.ServiceException;
import com.book.common.util.PageObject;
import com.book.mapper.UserMapper;
import com.book.mapper.UserRoleMapper;
import com.book.pojo.User;
import com.book.service.UserService;

/**
 * 用户操作实现类
 * 
 * @author LiYuanbin
 * @since 2018年3月30日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void login(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		subject.login(token);
	}

	@Override
	public int updateUser(User user, String roleIds) {
		if (user == null)
			throw new ServiceException("用戶对象不能为空");
		if (user.getUserId() == null)
			throw new ServiceException("用户id不能为空");
		if (StringUtils.isEmpty(roleIds))
			throw new ServiceException("用户角色不能为空");
		String pwd = user.getPassword();
		if (!StringUtils.isEmpty(pwd)) {
			ByteSource source = ByteSource.Util.bytes(pwd.getBytes());
			String salt = UUID.randomUUID().toString();
			SimpleHash simpleHash = new SimpleHash("MD5", source, salt);
			user.setPassword(simpleHash.toHex());// 转为16进制形式
			user.setSalt(salt);// 保存盐值
		}
		int rows = userMapper.updateByPrimaryKey(user);
		// roleMapper.delete

		return rows;
	}

	@Override
	public Map<String, User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user, String roleIds) {
		String username = user.getUsername();
		String pwd = user.getPassword();

		if (StringUtils.isEmpty(username))
			throw new ServiceException("用户名不能为空");
		if (StringUtils.isEmpty(pwd))
			throw new ServiceException("密码不能为空");

		ByteSource source = ByteSource.Util.bytes(pwd.getBytes());
		String salt = UUID.randomUUID().toString();
		SimpleHash simpleHash = new SimpleHash("MD5", source, salt);
		user.setPassword(simpleHash.toHex());
		user.setSalt(salt);
		List<Integer> idsList = new ArrayList<>();
		for (String ids : roleIds.split(",")) {
			idsList.add(Integer.parseInt(ids));
		}
		userMapper.insertUser(user);
		try {
			userRoleMapper.insertRoleUser(user.getUserId(), idsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PageObject<User> findPageObjects(String username, Integer pageCurrent) {
		// TODO Auto-generated method stub
		return null;
	}

}
