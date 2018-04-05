package com.book.mapper;

import java.util.List;

import com.book.pojo.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

	List<String> findUserPermissions(Long userId);
	
	/**
	 * 依据用户与名查找用户信息
	 * 
	 * @param username
	 * @return
	 */
	User findUserByUserName(String username);
	
	/**
	 * 用户注册 
	 * 
	 * @param user
	 */
	void insertUser(User user);

}
