package com.kunpeng.dao;

import com.kunpeng.entity.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUserName(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明用户名和密码错误，反之亦然
     */
    public User queryUserByUserNameAndPassword(String username,String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(User user);


}
