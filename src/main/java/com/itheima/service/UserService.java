package com.itheima.service;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;

import java.util.Map;

public interface UserService {

    //根据用户名查询用户
    User findByUsername(String username);

    //用户注册
    void register(String username, String password);

    //更新用户信息
    void update(User user);

    //更新用户头像
    void updateAvatar(String avatarUrl);

    //更新用户密码
    Result<?> validateAndUpdatePwd(Map<String, String> params);
}
