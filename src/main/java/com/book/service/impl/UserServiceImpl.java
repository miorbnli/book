package com.book.service.impl;

import java.util.Map;

import com.book.common.util.PageObject;
import com.book.pojo.User;
import com.book.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateUser(User entity, String roleIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveUser(User entity, String roleIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageObject<User> findPageObjects(String username, Integer pageCurrent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
