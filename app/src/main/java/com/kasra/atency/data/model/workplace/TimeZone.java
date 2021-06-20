package com.kasra.atency.data.model.workplace;

import com.google.gson.annotations.SerializedName;

public class TimeZone {

    @SerializedName("ID")
    private Integer iD;

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }
}
