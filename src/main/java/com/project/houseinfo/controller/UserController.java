package com.project.houseinfo.controller;

import com.project.houseinfo.common.model.User;
import com.project.houseinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {
  @Autowired
  private UserService userService;
  @ResponseBody
  @RequestMapping("user")
  public List<User>getUsers(){
    return userService.getUsers();
  }

  @RequestMapping("userDetail")
  public String userDetail(ModelMap modelMap){
       List<User>users=userService.getUsers();
       User one=users.get(0);
       modelMap.put("user",one);
       return "user-detail";
  }
    @RequestMapping("index")
    public String index(){
       return "homepage/index";
    }
}
