<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yuping.liu.pojo.Post" %>
<%@ page import="javafx.geometry.Pos" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yuping.liu.dao.impl.ReplaydaoImpl" %>
<%@ page import="com.yuping.liu.pojo.Replay" %>
<%@ page import="com.yuping.liu.dao.impl.PostdaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/details.css">
    <%
        String str=request.getParameter("postid");
        int postid=0;
        if(str!=null){
            postid=Integer.valueOf(request.getParameter("postid"));
        }else {
            postid=((Post)request.getSession().getAttribute("post")).getPostid();
        }
        PostdaoImpl postdao = new PostdaoImpl();
        Post post= postdao.findPostByPostid(postid);
        request.getSession().setAttribute("post",post);

        ReplaydaoImpl replaydao=new ReplaydaoImpl();
        ArrayList<Replay> replays=replaydao.findAllReplayByPostid(postid);
        request.getSession().setAttribute("replays",replays);
        //System.out.println(replays);
    %>
</head>
<body>
<div class="center-content h-center">
    <div class="blogger clearfix " >
        <div class="blooger-info clearfix">
            <div class="blogger-img"><img src="../image/${post.userimg}"></div>
            <div class="blogger-username v-center">${post.username}</div>
        </div>
        <div class="blogger-infotype">类型：${post.postinfotype}</div>
        <div class="blogger-title">标题：${post.posttitle}</div>
        <div class="blogger-content">${post.postcontent}</div>
        <div class="replay clearfix">
            <div class="partline v-center"></div>
            <div class="btn-replay"><a href="./replay.jsp?postid=${post.postid}">回复</a></div>
        </div>
    </div>
    <c:forEach items="${replays}" var="replay">
    <div class="replay-post clearfix">
        <div id="replay-post-title">${replay.replaytitle}</div>
        <div class="replay-post-content">${replay.replaycontent}</div>
        <div class="replay-post-info clearfix">
            <div class="replay-post-name">来自：${replay.username}</div>
            <div class="replay-post-time">${replay.replaytime}</div>
        </div>
        <div class="replay clearfix">
            <div class="partline v-center"></div>
            <div class="btn-replay"><a href="./replay.jsp?postid=${post.postid}">回复</a></div>
        </div>
    </div>
    </c:forEach>
</div>
</body>
</html>
