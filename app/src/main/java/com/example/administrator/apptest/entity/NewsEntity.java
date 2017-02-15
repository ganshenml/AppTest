package com.example.administrator.apptest.entity;

import java.io.Serializable;

/**
 * Created by liqiang on 2016/4/5.
 */
public class NewsEntity implements Serializable {
    private String NewsID;
    private String Title;
    private boolean Recommend;
    private String PostDate;
    private String Author;
    private String CoverPic;
    private int NeedLogin;
    private String Pageviews;
    private String CoverMobilePic;

    public String getCoverMobilePic() {
        return CoverMobilePic;
    }

    public void setCoverMobilePic(String CoverMobilePic) {
        this.CoverMobilePic = CoverMobilePic;
    }

    public String getNewsID() {
        return NewsID;
    }

    public void setNewsID(String NewsID) {
        this.NewsID = NewsID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public boolean getRecommend() {
        return Recommend;
    }

    public void setRecommend(boolean Recommend) {
        this.Recommend = Recommend;
    }

    public int getNeedLogin() {
        return NeedLogin;
    }

    public void setNeedLogin(int NeedLogin) {
        this.NeedLogin = NeedLogin;
    }

    public String getPageviews() {
        return Pageviews;
    }

    public void setPageviews(String Pageviews) {
        this.Pageviews = Pageviews;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String PostDate) {
        this.PostDate = PostDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCoverPic() {
        return CoverPic;
    }

    public void setCoverPic(String CoverPic) {
        this.CoverPic = CoverPic;
    }
}
