package com.kasra.atency.data.model.workplace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyTimeZone {
    @SerializedName("ID")
    @Expose
    private Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
