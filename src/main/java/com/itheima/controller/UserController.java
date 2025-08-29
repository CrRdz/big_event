package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$")String username, @Pattern(regexp = "^\\S{5,16}$")String password){
        //1.根据用户名查询用户
        User loginUser = userService.findByUsername(username);
        //2.判断用户是否存在
        if(loginUser == null) {
            return Result.error("用户名错误");
        }
        //3.判断密码是否正确
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            //4.登录成功生成jwt令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> info(@RequestHeader(name = "Authorization") String token){
        //1.根据用户名查询用户
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        User user = userService.findByUsername(username);
        return Result.success(user);
    }
}
