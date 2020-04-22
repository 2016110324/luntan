package com.yuping.liu.service;

import com.yuping.liu.pojo.BaseDto;
import com.yuping.liu.pojo.User;

public interface UserService {
    BaseDto<User> loginUser(User user);

    BaseDto<User> registerUser(User user);

}
