package com.yuping.liu.dao;

import com.yuping.liu.pojo.Replay;

import java.util.ArrayList;

public interface Replaydao {
    ArrayList<Replay> findAllReplayByPostid(int postid);

}
