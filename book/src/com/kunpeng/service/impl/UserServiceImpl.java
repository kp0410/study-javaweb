package com.kunpeng.service.impl;

import com.kunpeng.dao.UserDao;
import com.kunpeng.dao.impl.UserDaoImpl;
import com.kunpeng.entity.User;
import com.kunpeng.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUserName(username) != null;
    }
}
