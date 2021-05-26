package com.base.base_app.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IDModel {
    @SerializedName("ID")
    @Expose
    private Integer iD;

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }
}
