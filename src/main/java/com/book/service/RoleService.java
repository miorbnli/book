package com.book.service;

import java.util.List;
import com.book.pojo.Role;

/**
 * 角色持久层类
 * 
 * @author LiYuanbin
 * @since 2018年3月30日
 */
public interface RoleService {

	/**
	 * 根据id执行删除操作
	 * 
	 * @param roleIds
	 * @return
	 */
	void deleteRole(List<Integer> roleIds);

	/**
	 * 保存角色信息
	 * 
	 * @param role
	 * @param menuIds
	 * @return
	 */
	void saveRole(Role role);

	/**
	 * 根据id查询角色信息
	 * 
	 * @param id
	 * @return
	 */
	Role findRoleById(Integer id);

	/**
	 * 修改角色信息
	 * 
	 * @param Role
	 * @param menuIds
	 * @return
	 */
	void updateRole(Role Role);
	
}
