package com.yuping.liu.pojo;

public class Post {
    private int postid;
    private int userid;
    private String username;
    private String userimg;
    private String postinfotype;
    private String posttitle;
    private String postcontent;
    private String postlastreplayname;
    private String postlastreplaytime;
    private int postreplaycount;

    public Post(int postid, String username, String userimg,
                String postinfotype, String posttitle, String postcontent,
                String postlastreplayname, String postlastreplaytime, int postreplaycount) {
        this.postid = postid;
        this.username = username;
        this.userimg = userimg;
        this.postinfotype = postinfotype;
        this.posttitle = posttitle;
        this.postcontent = postcontent;
        this.postlastreplayname = postlastreplayname;
        this.postlastreplaytime = postlastreplaytime;
        this.postreplaycount = postreplaycount;
    }

    public Post(int userid, String postinfotype, String posttitle, String postcontent,
                String postlastreplayname, String postlastreplaytime, int postreplaycount) {
        this.userid = userid;
        this.postinfotype = postinfotype;
        this.posttitle = posttitle;
        this.postcontent = postcontent;
        this.postlastreplayname = postlastreplayname;
        this.postlastreplaytime = postlastreplaytime;
        this.postreplaycount = postreplaycount;
    }

    public Post(int postid, int userid, String postlastreplayname, String postlastreplaytime, int postreplaycount) {
        this.postid = postid;
        this.userid = userid;
        this.postlastreplayname = postlastreplayname;
        this.postlastreplaytime = postlastreplaytime;
        this.postreplaycount = postreplaycount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getPostinfotype() {
        return postinfotype;
    }

    public void setPostinfotype(String postinfotype) {
        this.postinfotype = postinfotype;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public String getPostlastreplayname() {
        return postlastreplayname;
    }

    public void setPostlastreplayname(String postlastreplayname) {
        this.postlastreplayname = postlastreplayname;
    }

    public String getPostlastreplaytime() {
        return postlastreplaytime;
    }

    public void setPostlastreplaytime(String postlastreplaytime) {
        this.postlastreplaytime = postlastreplaytime;
    }

    public int getPostreplaycount() {
        return postreplaycount;
    }

    public void setPostreplaycount(int postreplaycount) {
        this.postreplaycount = postreplaycount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", username='" + username + '\'' +
                ", userimg='" + userimg + '\'' +
                ", postinfotype='" + postinfotype + '\'' +
                ", posttitle='" + posttitle + '\'' +
                ", postcontent='" + postcontent + '\'' +
                ", postlastreplayname='" + postlastreplayname + '\'' +
                ", postlastreplaytime='" + postlastreplaytime + '\'' +
                ", postreplaycount=" + postreplaycount +
                '}';
    }
}
