package com.book.mapper;
import java.util.List;

import com.book.pojo.Role;

import tk.mybatis.mapper.common.Mapper;

/**
 * 角色 持久层对象
 * @author LiYuanbin
 * @since 2018年3月30日
 */
public interface RoleMapper  extends Mapper<Role>{
	/**
	 * 根据角色ids批量删除角色
	 * @param roleIds
	 */
	void deleteRoleByIds(List<Integer> roleIds);
	
	/**
	 * 删除用户和角色关系表
	 * @param userId
	 */
	void deleteRoleUser(Integer userId);
}










