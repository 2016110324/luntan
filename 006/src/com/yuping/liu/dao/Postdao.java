package com.yuping.liu.dao;

import com.yuping.liu.pojo.Post;

import java.util.ArrayList;

public interface Postdao {
    ArrayList<Post> findAllPost();
    ArrayList<Post> findPostByCount();
    boolean addPost(Post post);
    
}
