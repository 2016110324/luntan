package com.yuping.liu.web;

import com.yuping.liu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"*.action", "*.jsp"})
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 放行前
        /**
         * 判断是否有session，有就放行
         * 没有：拦截
         *   跳转到指定的页面
         */

        // 1. 参数的强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        //准备放行的url
        String urls = "/,/index.jsp,/login.action,/register.action";
        // 获取当前的请求的url
        String requestURL = request.getRequestURL().toString();
        String url = requestURL.substring(requestURL.lastIndexOf("/"));

        if (urls.indexOf(url) == -1) {


            // 2. 获取session
            HttpSession session = request.getSession();

            // 3. 判断sessions是否有值
            User user = (User) session.getAttribute("user");

            if (user == null) {
                //拦截到了！
               request.getRequestDispatcher("./tips.jsp").forward(request,response);
                return;
            }
        }
        chain.doFilter(req, resp);

        // 放行后
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤被创建成功");
    }

}
