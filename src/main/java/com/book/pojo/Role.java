package com.book.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.book.common.po.BasePojo;

/**
 * 角色实体类
 * 
 * @author LiYuanbin
 * @since 2018年3月30日
 */
@Table(name="role")
public class Role extends BasePojo{
	private static final long serialVersionUID = -4384214247964590665L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    private String note;

    private String createduser;

    private String modifieduser;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getCreateduser() {
        return createduser;
    }

    public void setCreateduser(String createduser) {
        this.createduser = createduser == null ? null : createduser.trim();
    }

    public String getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifieduser = modifieduser == null ? null : modifieduser.trim();
    }
}