package com.yuping.liu.service.impl;

import com.yuping.liu.dao.impl.UserdaoImpl;
import com.yuping.liu.pojo.BaseDto;
import com.yuping.liu.pojo.User;
import com.yuping.liu.util.StringUtil;

public class UserServiceImpl {
    private UserdaoImpl userdao = new UserdaoImpl();

    public BaseDto<User> loginUser(User user) {
        if (user.getUsername().equals("") || user.getUsername() == null) {
            return new BaseDto<User>(400, "用户名为空", null);
        }
        if (!userdao.isUser(user.getUsername())) {
            return new BaseDto<User>(400, "该用户不存在", null);
        }
        if (user.getUserpwd().equals("") || user.getUserpwd() == null) {
            return new BaseDto<User>(400, "密码为空", null);
        }
        if (!userdao.getUserpassword(user.getUsername()).equals(user.getUserpwd())) {
            return new BaseDto<User>(400, "用户、密码错误", null);
        } else {
            return new BaseDto<User>(200, "登录成功", userdao.findByName(user.getUsername()));
        }

    }

    public BaseDto<User> registerUser(User user) {
        if (user.getUsername().equals("") || user.getUsername() == null) {
            return new BaseDto<User>(400, "请输入用户名", null);
        }
        if (user.getUseremail().equals("") || user.getUseremail()== null) {
            return new BaseDto<User>(400, "请输入邮箱号", null);
        }
        if (user.getUserphone().equals("") || user.getUserphone() == null) {
            return new BaseDto<User>(400, "请输入手机号", null);
        }
        if (!StringUtil.isMobileNO(user.getUserphone())) {
            return new BaseDto<User>(400, "请输入正确的手机号", null);
        }
        if (!StringUtil.checkEmail(user.getUseremail())) {
            return new BaseDto<User>(400, "请输入正确的邮箱号", null);
        }
        if (user.getUserpwd().equals("") || user.getUserpwd() == null) {
            return new BaseDto<User>(400, "请输入密码", null);
        }else {
            userdao.addUser(user);
            return new BaseDto<User>(200, "注册成功！", user);
        }

    }
}
