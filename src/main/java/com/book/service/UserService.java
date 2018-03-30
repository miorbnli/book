package com.book.service;

import java.util.Map;

import com.book.common.util.PageObject;
import com.book.pojo.User;

public interface UserService {
	/**
	 * 根据用户名和密码进行登录验证
	 * 
	 * @param username
	 * @param password
	 */
	void login(String username,String password);
	
	/**
	 * 更新用户信息
	 * 
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateUser(User entity,String roleIds);
	
	/**
	 *根据id查询用户信息以及用户关联的角色信息 
	 *@param  id 表示用户id
	 *@return 包含用户信息以及角色信息
	 */
	Map<String,User> findUserById(Long id);
	
	int saveUser(User entity,String roleIds);
	
	PageObject<User> findPageObjects(String username, Integer pageCurrent);
	
	/**禁用和启用*/
	int validById(Integer id,Integer valid,String modifiedUser);
	
}
