package com.example.administrator.apptest.entity;

import java.io.Serializable;

/**
 * Created by liqiang on 2016/4/1.
 */
public class HomeViewpagerEntity implements Serializable {
    private String ObjectID;
    private String Pic;
    private int Object;
    private String Title;
    private String Link;

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public HomeViewpagerEntity(String ObjectID, String Pic, int Object) {
        this.ObjectID = ObjectID;
        this.Pic = Pic;
        this.Object = Object;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String ObjectID) {
        this.ObjectID = ObjectID;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String Pic) {
        this.Pic = Pic;
    }

    public int getObject() {
        return Object;
    }

    public void setObject(int Object) {
        this.Object = Object;
    }
}
