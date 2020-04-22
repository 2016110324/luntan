package com.yuping.liu.web;

import com.yuping.liu.pojo.BaseDto;
import com.yuping.liu.pojo.User;
import com.yuping.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.action")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("loginname");
        String pwd=request.getParameter("loginpwd");
        int count= (int) request.getServletContext().getAttribute("userlen");
        System.out.println("jinrulr");
        User user=new User(name,pwd);
        UserServiceImpl userService=new UserServiceImpl();
        BaseDto<User> baseDto=userService.loginUser(user);
        if(baseDto.getCode()==200){
            count += 1;
            request.getServletContext().setAttribute("userlen",count);
            System.out.println("user:............."+baseDto.getData());
            request.getSession().setAttribute("user",baseDto.getData());
            response.getWriter().write("true");
        }else {
            response.getWriter().write(baseDto.getMsg());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
