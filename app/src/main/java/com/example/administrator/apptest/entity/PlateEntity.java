package com.example.administrator.apptest.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by liqiang on 2016/5/5.
 */
@Table(name = "plate")
public class PlateEntity implements Serializable {
    @Column(id = true)
    private String id;
    @Column(type = Column.ColumnType.SERIALIZABLE)
    private ArrayList<PublicNavigationEntity> response;
    @Column
    private String message;
    @Column
    private int resultid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<PublicNavigationEntity> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<PublicNavigationEntity> response) {
        this.response = response;
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
}
