<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.yuping.liu.dao.impl.PostdaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yuping.liu.pojo.Post" %>
<%@ page import="com.yuping.liu.dao.impl.PostdaoImpl" %>
<%@ page import="com.yuping.liu.dao.impl.UserdaoImpl" %>
<%@ page import="com.yuping.liu.dao.impl.ReplaydaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>论坛</title>
      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="css/jquery-ui.css">
      <script src="js/jquery-3.4.0.js"></script>
      <script src="js/jquery-ui.js"></script>
      <script src="js/demo.js"></script>
      <%
          PostdaoImpl postdao=new PostdaoImpl();
          //left
          ArrayList<Post> posts=new ArrayList<>();
          posts=postdao.findAllPost();
          request.getSession().setAttribute("posts",posts);
          System.out.println(posts);
          //right1
          ArrayList<Post> posts2=new ArrayList<>();
          posts2=postdao.findPostByCount();
          request.getSession().setAttribute("newposts",posts2);
          System.out.println(posts2);
          //right2
          UserdaoImpl userdao=new UserdaoImpl();
          int userlen=userdao.findAllUserLen();
          request.getServletContext().setAttribute("userlen",userlen);
          System.out.println(userlen);
          ReplaydaoImpl replaydao=new ReplaydaoImpl();
          request.getSession().setAttribute("replaycount",replaydao.findReplaycount());

      %>
      <script>
          function click() {
              $(".login-dialog").dialog("open");
          }
      </script>
  </head>
  <body>
  <div id="header">
      <div id="header-content" class="clearfix">
          <div id="logo" class="v-center">
              <img src="image/log.png" alt="login" >
          </div>
          <div id="searchbar" class="v-center">
              <input type="text" name="searchtext" id="searchtext">
          </div>
          <div id="login-link" class="v-center">
              <c:if test="${user.username != null}">
                  <a id="btn-publish" class="link" href="./pages/publish.jsp">发帖</a>
                  <a id="btn-register" class="link" href="#">用户：${user.username}</a>
                  <a id="btn-login" class="link" href="./pages/exit.jsp">退出登录</a>
             </c:if >
              <c:if test="${user.username == null}">
                <a id="btn-register" class="link" href="#">注册</a>
                <a id="btn-login" class="link" href="#">登录</a>
              </c:if >
          </div>
      </div>
  </div>
  <div class="register-dialog">
      <form action="#">
          <!-- table>(tr>tb*2)*5 -->
          <div class="tps"></div>
          <table class="logintext-right">
              <tr>
                  <td>用户名</td>
                  <td><input type="text" name="" id="username"></td>
              </tr>
              <tr>
                  <td>邮箱</td>
                  <td><input type="email" name="" id="useremail"></td>
              </tr>
              <tr>
                  <td>手机号</td>
                  <td><input type="tel" name="" id="userephone"></td>
              </tr>
              <tr>
                  <td>密码</td>
                  <td><input type="password" name="" id="userpwd1"></td>
              </tr>
              <tr>
                  <td>确认密码</td>
                  <td><input type="password" name="" id="userpwd2"></td>
              </tr>
          </table>
      </form>
  </div>
  <div class="login-dialog">
      <div class="tps"></div>
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="" id="loginname"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="" id="loginpwd"></td>
          </tr>
      </table>
  </div>
  <div id="content" class="clearfix">
      <div id="content-left">
          <div id="nav">
              <ul class="clearfix">
                  <li><a href="#" class="current-active">技术</a></li>
                  <li><a href="#">创意</a></li>
                  <li><a href="#">好玩</a></li>
                  <li><a href="#">Apple</a></li>
                  <li><a href="#">酷工作</a></li>
                  <li><a href="#">交易</a></li>
                  <li><a href="#">城市</a></li>
                  <li><a href="#">问与答</a></li>
              </ul>
          </div>
          <c:forEach items="${posts}" var="post">
          <div id="posts" class="clearfix">
              <div class="avator">
                  <img src="image/${post.userimg}" alt="">
              </div>
              <div id="post-title">
                  <div id="post-title-text">
                      <a href="./pages/details.jsp?postid=${post.postid}" title="${post.postcontent}">${post.postcontent}</a>
                  </div>
                  <div id="post-info" class="clearfix">
                      <div class="post-info-text">
                          <ul class="clearfix">
                              <li><p>${post.postinfotype}</p></li>
                              <li><p>.</p></li>
                              <li><p>${post.username}</p></li>
                              <li><p>.</p></li>
                              <li><p>${post.postlastreplaytime}</p></li>
                              <li><p>.</p></li>
                              <li><p>${post.postlastreplayname}</p></li>
                          </ul>
                      </div>
                      <div class="reply" >
                          <span class="reply-count">${post.postreplaycount}</span>
                      </div>
                  </div>
              </div>
          </div>
      </c:forEach>
      </div>
      <div id="content-right1">
          <div class="right-header">
              <a href="#">今日热议主题</a>
          </div>
          <c:forEach items="${newposts}" var="post">
          <div id="posts-right">
              <div id="avator-right">
                  <img src="image/${post.userimg}" alt="">
              </div>
              <div id="post-title-right">
                  <div id="post-title-text-right">
                      <a href="#" title="${post.posttitle}">
                              ${post.posttitle}</a>
                  </div>
              </div>
          </div>
          </c:forEach>
      </div>
      <div class="content-right2">
          <div class="right2-title">
              <a href="#">社区讨论情况</a>
          </div>
          <div class="right2-content">
              <div class="static-content clearfix">
                  <div class="static">注册会员：</div>
                  <div class="static-register-count">${userlen}</div>
              </div>
              <div class="static-content clearfix">
                  <div class="static">主题：</div>
                  <div class="static-title-count">${posts.size()}</div>
              </div>
              <div class="static-content clearfix">
                  <div class="static">回复：</div>
                  <div class="static-replay-count">${replaycount}</div>
              </div>

          </div>
          <div class="scoreboard">
              <div class="fortune">
                  > 财富排行榜
              </div>
              <div class="consumption">
                  > 消费排行榜
              </div>
          </div>
      </div>
  </div>
  <div id="footer">
      <div id="footer-content" >
          <div id="footer-links">
              <ul class="clearfix">
                  <li><a class="link" href="#">关于</a></li>
                  <li><a class="link" href="#">FAQ</a></li>
                  <li><a class="link" href="#">API</a></li>
                  <li><a class="link" href="#">我们的愿景</a></li>
                  <li><a class="link" href="#">广告投放</a></li>
                  <li><a class="link" href="#">鸣谢</a></li>
              </ul>
          </div>
          <div id="copy-right" class="v-center h-center" >
              版权说明：四川师范大学 计算机科学学院 刘玉萍
          </div>
          <div id="update-date">
              最后更新日期：2019年6月1日
          </div>
      </div>
  </div>
  </body>
</html>