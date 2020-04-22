package com.yuping.liu.util;

import java.sql.*;

public class DBHelperUtils {
    private String ClassName = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/experiment";
    private String UserName = "root";
    private String Password = "root";
    //定义数据库连接对象
    private Connection conn;
    //SQL语句执行的容器对象
    private Statement stmt;

    //定义个无参的构造函数
    public DBHelperUtils() {
        try {
            //加载数据库连接的驱动程序类
            Class.forName(ClassName);
            //实例化连接对象
            conn = DriverManager.getConnection(URL, UserName, Password);
            //实例化SQL语句执行的容器对象
            System.out.println("连接成功");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("连接失败");
        }
    }

    //定义个无参的构造函数
    public DBHelperUtils(String URL, String UserName, String Password) {
        this.URL = URL;
        this.UserName = UserName;
        this.Password = Password;
        try {
            //加载数据库连接的驱动程序类
            Class.forName(ClassName);
            //实例化连接对象
            conn = DriverManager.getConnection(URL, UserName, Password);
            //实例化SQL语句执行的容器对象
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {

        }
    }

    //根据参数SQL执行数据修改命令
    public boolean Update(String SQL) {
        try {
            System.out.println(SQL+"执行成功");
            stmt.execute(SQL);
            return true;
            //return true;
            //return stmt.execute(SQL);
        } catch (SQLException e) {
            System.out.println(SQL+"执行失败");
            return false;
        }
    }

    //根据参数SQL执行查询数据命令
    public ResultSet Query(String SQL) {
        try {
            System.out.println(SQL+"执行成功");
            return stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println(SQL+"执行失败");
            return null;
        }
    }

}
