package com.yuping.liu.web;

import com.yuping.liu.pojo.BaseDto;
import com.yuping.liu.pojo.User;
import com.yuping.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.action")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String userphone=request.getParameter("userphone");
        String useremail=request.getParameter("useremail");
        String userpwd=request.getParameter("userpwd");
        User user=new User(username,userpwd,userphone,useremail);
        UserServiceImpl userService=new UserServiceImpl();
        BaseDto<User> baseDto=userService.registerUser(user);
        if(baseDto.getCode()==200){
            response.getWriter().write("true");
        }else {
            response.getWriter().write(baseDto.getMsg());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
