package com.yuping.liu.dao.impl;

import com.yuping.liu.pojo.User;
import com.yuping.liu.util.DBHelperUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserdaoImpl {
    private DBHelperUtils helper = new DBHelperUtils();

    public boolean addUser(User user) {
        String sql = "insert into user(username,userpwd,userphone,useremail) values ('%s','%s','%s','%s')";
        sql = String.format(sql, user.getUsername(),user.getUserpwd(),user.getUserphone(),user.getUseremail());
        System.out.println(sql);
        return helper.Update(sql);
    }

    public boolean updateUser(String name, String password) {
        String sql = "update user set userpwd='%s' where username='%s'";
        sql = String.format(sql, password, name);
        System.out.println(sql);
        return helper.Update(sql);
    }

    public boolean deleteUser(String name) {
        String sql = "delete from user where username='%s'";
        sql = String.format(sql, name);
        System.out.println(sql);
        return helper.Update(sql);
    }

    public boolean isUser(String name) {
        String sql = "select userid from user where username='%s'";
        sql = String.format(sql, name);
        ResultSet resultSet = helper.Query(sql);
        int count = 0;
        try {
            while (resultSet.next()) {
                count++;
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count != 0 ? true : false;
    }

    public String getUserpassword(String name) {
        String sql = "select userpwd from user where username='%s'";
        sql = String.format(sql, name);
        ResultSet resultSet = helper.Query(sql);
        String pwd = null;
        try {
            while (resultSet.next()) {
                pwd = resultSet.getString("userpwd");
                System.out.println(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwd;
    }

    public User findByName(String name) {
        String sql = "select * from user where username='%s' limit 1";
        sql = String.format(sql, name);
        ResultSet resultSet = helper.Query(sql);
        User user = null;
        try {
            while (resultSet.next()) {
                user = new User(resultSet.getInt("userid"), resultSet.getString("userimg"),
                        resultSet.getString("username"), resultSet.getString("userpwd"),
                        resultSet.getString("userphone"), resultSet.getString("useremail"));
                System.out.println("usershgddy:"+user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int findAllUserLen() {
        String sql = "select userid from user";
        sql = String.format(sql);
        ResultSet resultSet = helper.Query(sql);
        int count = 0;
        try {
            while (resultSet.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }
}
