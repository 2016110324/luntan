package com.yuping.liu.pojo;

public class User {
    private int userid;
    private String userimg;
    private String username;
    private String userpwd;
    private String useremail;
    private String userphone;

    public User(int userid, String userimg, String username, String userpwd, String useremail, String userphone) {
        this.userid = userid;
        this.userimg = userimg;
        this.username = username;
        this.userpwd = userpwd;
        this.useremail = useremail;
        this.userphone = userphone;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public User(String username, String userpwd, String userphone, String useremail) {
        this.username = username;
        this.userpwd = userpwd;
        this.userphone = userphone;
        this.useremail = useremail;
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

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "{" +
                "userid:'" + userid + '\'' +
                ", username:'" + username + '\'' +
                ", userpwd:'" + userpwd + '\'' +
                ", userphone:'" + userphone + '\'' +
                ", useremail:'" + useremail + '\'' +
                '}';
    }
}
