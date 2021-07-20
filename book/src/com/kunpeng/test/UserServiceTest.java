package com.kunpeng.test;

import com.kunpeng.entity.User;
import com.kunpeng.service.UserService;
import com.kunpeng.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"lpc","123456","lpc0514@163.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "admin", "admin1", "admin"));
        System.out.println(user);
        if (user == null){
            System.out.println("登录失败！");
        }else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void existsUsername() {
        boolean admin = userService.existsUsername("admin");
        if (admin == true){
            System.out.println("用户名已存在！");
        }else{
            System.out.println("用户名可用！");
        }
    }
}