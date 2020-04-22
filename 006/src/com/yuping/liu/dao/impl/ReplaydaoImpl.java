package com.yuping.liu.dao.impl;

import com.yuping.liu.pojo.Replay;
import com.yuping.liu.util.DBHelperUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplaydaoImpl {
    private DBHelperUtils helper=new DBHelperUtils();
    public ArrayList<Replay> findAllReplayByPostid(int postid){
        String sql = "select * from replay ,user where postid='%s' and user.userid=replay.userid";
        sql = String.format(sql,postid);
        ResultSet res = helper.Query(sql);
        ArrayList<Replay> replays =new ArrayList<>();
        try {
            while (res.next()) {
                Replay replay=new Replay(res.getInt("replayid"),res.getInt("postid"),
                        res.getInt("userid"), res.getString("username"),
                        res.getString("userimg"), res.getString("replaytitle"),
                        res.getString("replaycontent"),
                        res.getString("replaytime"));
                System.out.println(replay);
               replays.add(replay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replays;
    }
    public int  findReplaycount(){
        String sql = "select count(*) from replay";
        ResultSet res = helper.Query(sql);
        int replaycount = 0;
        try {
            while (res.next())
                replaycount=res.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replaycount;
    }
    public boolean  addReplay(Replay replay){
        String sql = "insert into replay(postid,userid,replaytitle,replaycontent,replaytime)values('%s','%s','%s','%s','%s')";
        sql=String.format(sql,replay.getPostid(),replay.getUserid(),replay.getReplaytitle(),replay.getReplaycontent(),replay.getReplaytime());
        return helper.Update(sql);
    }
}
