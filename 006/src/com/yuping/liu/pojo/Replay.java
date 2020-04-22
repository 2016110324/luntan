package com.yuping.liu.pojo;

public class Replay {
    private int relayid;
    private int postid;
    private int userid;
    private String username;
    private String userimg;
    private String replaytitle;
    private String replaycontent;
    private String replaytime;

    public Replay(int relayid, int postid, int userid, String username,
                  String userimg, String replaytitle, String replaycontent, String replaytime) {
        this.relayid = relayid;
        this.postid = postid;
        this.userid = userid;
        this.username = username;
        this.userimg = userimg;
        this.replaytitle = replaytitle;
        this.replaycontent = replaycontent;
        this.replaytime = replaytime;
    }

    public Replay(int postid, int userid, String replaytitle, String replaycontent, String replaytime) {
        this.postid = postid;
        this.userid = userid;
        this.replaytitle = replaytitle;
        this.replaycontent = replaycontent;
        this.replaytime = replaytime;
    }

    public int getRelayid() {
        return relayid;
    }

    public void setRelayid(int relayid) {
        this.relayid = relayid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getReplaytitle() {
        return replaytitle;
    }

    public void setReplaytitle(String replaytitle) {
        this.replaytitle = replaytitle;
    }

    public String getReplaycontent() {
        return replaycontent;
    }

    public void setReplaycontent(String replaycontent) {
        this.replaycontent = replaycontent;
    }

    public String getReplaytime() {
        return replaytime;
    }

    public void setReplaytime(String replaytime) {
        this.replaytime = replaytime;
    }

    @Override
    public String toString() {
        return "Replay{" +
                "relayid=" + relayid +
                ", postid=" + postid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", userimg='" + userimg + '\'' +
                ", replaytitle='" + replaytitle + '\'' +
                ", replaycontent='" + replaycontent + '\'' +
                ", replaytime='" + replaytime + '\'' +
                '}';
    }
}
