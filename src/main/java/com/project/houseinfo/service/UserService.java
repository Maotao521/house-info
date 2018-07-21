package com.project.houseinfo.service;

import java.util.List;

import com.project.houseinfo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.houseinfo.common.model.User;
@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;
  public List<User> getUsers() {
    return userMapper.selectUsers();
  }
}
