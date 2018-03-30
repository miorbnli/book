package com.book.mapper;

import java.util.List;

import com.book.pojo.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

	List<String> findUserPermissions(Long userId);

	User findObjectByUserName(String username);

}
