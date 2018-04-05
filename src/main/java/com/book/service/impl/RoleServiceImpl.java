package com.book.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.book.mapper.RoleMapper;
import com.book.pojo.Role;
import com.book.service.RoleService;

/**
 * 角色操作实现类
 * 
 * @author LiYuanbin
 * @since 2018年3月30日
 */
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public void deleteRole(List<Integer> roleIds) {
		roleMapper.deleteRoleByIds(roleIds);
	}

	@Override
	public void saveRole(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public Role findRoleById(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void updateRole(Role Role) {
		roleMapper.updateByPrimaryKey(Role);
	}

}
