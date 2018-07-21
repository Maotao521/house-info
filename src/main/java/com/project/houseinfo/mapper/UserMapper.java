package com.project.houseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.houseinfo.common.model.User;

@Mapper
public interface UserMapper {

	public List<User> selectUsers();
}
