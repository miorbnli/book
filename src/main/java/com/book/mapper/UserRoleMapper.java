package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.RoleUser;

import tk.mybatis.mapper.common.Mapper;

/**
 * 用户和角色关系持久类
 * 
 * @author LiYuanbin
 * @since 2018年3月30日
 */
public interface UserRoleMapper extends Mapper<RoleUser>{
	/**
	 * 根据用户id删除角色和用户关联关系
	 * 
	 * @param userId
	 */
	void deleteRoleUser(Integer userId);

	/**
	 * 向表中写入用户和角色关系数据
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	void insertRoleUser(@Param("userId")Long userId, @Param("roleIds")List<Integer> roleIds);

	/**
	 * 根据用户id查询角色id
	 * 
	 * @param id
	 * @return
	 */
	List<Integer> findRolesByUserId(Integer id);
}
