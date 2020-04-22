package com.yuping.liu.web;

import com.yuping.liu.dao.impl.PostdaoImpl;
import com.yuping.liu.pojo.Post;
import com.yuping.liu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PublishServlet",urlPatterns = "/publish.action")
public class PublishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String publishtype=request.getParameter("infopublishtype");
        String publishtitle=request.getParameter("infopublishtitle");
        String publishDate = request.getParameter("content2") != null ? request.getParameter("content2") : "";

        User user=(User) request.getSession().getAttribute("user");
        PostdaoImpl postdao=new PostdaoImpl();
        Post post=new Post(user.getUserid(),publishtype,publishtitle,publishDate,"暂无信息","",0);
        postdao.addPost(post);
        //request.getSession().setAttribute("publishDate",publishDate);
        System.out.println("publish:"+post);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
