package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$")String username, @Pattern(regexp = "^\\S{5,16}$")String password){
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
    }
}
