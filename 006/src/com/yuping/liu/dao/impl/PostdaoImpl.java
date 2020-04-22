package com.yuping.liu.dao.impl;

import com.yuping.liu.pojo.Post;
import com.yuping.liu.util.DBHelperUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostdaoImpl {
    private DBHelperUtils helper=new DBHelperUtils();
    public ArrayList<Post> findAllPost(){
        String sql = "select *from post,user where post.userid=user.userid";
        ResultSet res = helper.Query(sql);
        ArrayList<Post> posts =new ArrayList<>();
        try {
            while (res.next()) {
                Post post=new Post(res.getInt("postid"),res.getString("username"),
                        res.getString("userimg"),res.getString("postinfotype"),
                        res.getString("posttitle"),res.getString("postcontent"),
                        res.getString("postlastreplayname"), res.getString("postlastrepalytime"),
                        res.getInt("postreplaycount"));
                System.out.println(post);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    public ArrayList<Post> findPostByCount(){
        String sql = "select * from post,user where post.userid=user.userid order by postreplaycount desc limit 0,4";
        ResultSet res = helper.Query(sql);
        ArrayList<Post> posts =new ArrayList<>();
        try {
            while (res.next()) {
                Post post=new Post(res.getInt("postid"),res.getString("username"),
                        res.getString("userimg"),res.getString("postinfotype"),
                        res.getString("posttitle"),res.getString("postcontent"),
                        res.getString("postlastreplayname"), res.getString("postlastrepalytime"),
                        res.getInt("postreplaycount"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    public Post findPostByPostid(int postid){
        String sql = "select * from post,user where postid='%s' and post.userid=user.userid";
        sql=String.format(sql,postid);
        ResultSet res = helper.Query(sql);
        Post post =null;
        try {
            while (res.next()) {
                 post=new Post(res.getInt("postid"),res.getString("username"),
                        res.getString("userimg"),res.getString("postinfotype"),
                        res.getString("posttitle"),res.getString("postcontent"),
                        res.getString("postlastreplayname"), res.getString("postlastrepalytime"),
                        res.getInt("postreplaycount"));
                System.out.println(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
    public boolean addPost(Post post){
        String sql = "insert into post(userid,postinfotype,posttitle,postcontent,postlastreplayname,postlastrepalytime,postreplaycount) values ('%s','%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql,post.getUserid(),post.getPostinfotype(),post.getPosttitle(),post.getPostcontent(),post.getPostlastreplayname(),post.getPostlastreplaytime(),post.getPostreplaycount());
        System.out.println(sql);
        return helper.Update(sql);
    }
    public boolean updatePost(Post post){
        String sql = "update post set postlastreplayname='%s' , postlastrepalytime='%s' , postreplaycount='%s' where postid='%s'";
        sql = String.format(sql,post.getPostlastreplayname(),post.getPostlastreplaytime(),post.getPostreplaycount(),post.getPostid());
        System.out.println(sql);
        return helper.Update(sql);
    }
}
