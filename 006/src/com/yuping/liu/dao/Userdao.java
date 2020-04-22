package com.yuping.liu.dao;

import com.yuping.liu.pojo.User;

public interface Userdao {
    boolean addUser(User user);

    boolean updateUser(String name);

    boolean deleteUser(String name);

    boolean isUser(String name);

    String getUserpassword(String name);
}
