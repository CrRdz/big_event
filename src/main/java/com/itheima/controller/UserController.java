package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(String username, String password){
        if(username == null && username.length() >= 5 && username.length() <= 16 &&
        password != null && password.length() >= 5 && password.length() <= 16
        ) {
            //1.查询用户
            User u = userService.findByUsername(username);
            if (u == null) {
                //2.没有用户，注册用户
                userService.register(username, password);
                return Result.success("注册成功");
            } else {
                //3.有用户，返回用户已存在
                return Result.error("用户已被占用");
            }
        }else {
            return Result.error("用户名或密码不符合规范");
        }
    }
}
