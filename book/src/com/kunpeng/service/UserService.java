package com.kunpeng.service;

import com.kunpeng.entity.User;

public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     *
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
