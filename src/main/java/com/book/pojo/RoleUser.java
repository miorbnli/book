package com.book.pojo;

import javax.persistence.Table;

/**
 * 角色和用户关系实体类
 * @author LiYuanbin
 * @since 2018年4月1日
 */
@Table(name="role_users")
public class RoleUser {
    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}