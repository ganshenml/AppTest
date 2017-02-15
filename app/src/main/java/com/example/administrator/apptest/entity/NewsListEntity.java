package com.example.administrator.apptest.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by liqiang on 2016/4/5.
 */
public class NewsListEntity implements Serializable {

    private ArrayList<NewsEntity> NewsList;
    private ArrayList<HomeViewpagerEntity> ChannelList;
    private String message;
    private int resultid;

    public ArrayList<HomeViewpagerEntity> getChannelList() {
        return ChannelList;
    }

    public void setChannelList(ArrayList<HomeViewpagerEntity> ChannelList) {
        this.ChannelList = ChannelList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultid() {
        return resultid;
    }

    public void setResultid(int resultid) {
        this.resultid = resultid;
    }

    public ArrayList<NewsEntity> getNewsList() {
        return NewsList;
    }

    public void setNewsList(ArrayList<NewsEntity> NewsList) {
        this.NewsList = NewsList;
    }
}
