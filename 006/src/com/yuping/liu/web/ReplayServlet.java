package com.yuping.liu.web;
import com.yuping.liu.dao.impl.PostdaoImpl;
import com.yuping.liu.dao.impl.ReplaydaoImpl;
import com.yuping.liu.pojo.Post;
import com.yuping.liu.pojo.Replay;
import com.yuping.liu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ReplayServlet",urlPatterns = "/replay.action")
public class ReplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
        String title=request.getParameter("inforeplaytitle");
        System.out.println(title);
        Post post= (Post) request.getSession().getAttribute("post");
        User user=(User) request.getSession().getAttribute("user");
        System.out.println(post);
        System.out.println(user);
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//多态
        Date date = new Date();//创建时间
        String time = bf.format(date);//格式化 bf.format(date);
        System.out.println("时间1："+time);

        ReplaydaoImpl replaydao=new ReplaydaoImpl();

        Replay replay=new Replay(post.getPostid(),user.getUserid(),title,htmlData,time);
        System.out.println(replay);

        replaydao.addReplay(replay);

        post.setPostlastreplayname(user.getUsername());
        post.setPostlastreplaytime(time);
        post.setPostreplaycount(post.getPostreplaycount()+1);

        PostdaoImpl postdao=new PostdaoImpl();
        postdao.updatePost(post);
        request.getRequestDispatcher("/pages/details.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
