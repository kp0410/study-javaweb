package com.kunpeng.test;

import com.kunpeng.dao.UserDao;
import com.kunpeng.dao.impl.UserDaoImpl;
import com.kunpeng.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUserName() {
        if (userDao.queryUserByUserName("admin") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在 ！");
        }
    }

    @Test
    public void queryUserByUserNameAndPassword() {
        if (userDao.queryUserByUserNameAndPassword("admin","admin12") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        int i = userDao.saveUser(new User(null, "gezi", "123456", "123456@qq.com"));
        if (i == -1){
            System.out.println("注册失败！");
        }else {
            System.out.println("注册成功！");
        }
    }
}