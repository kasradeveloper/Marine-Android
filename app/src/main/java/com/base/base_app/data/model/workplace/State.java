package com.base.base_app.data.model.workplace;

import androidx.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private Object name;
    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("Country")
    @Expose
    private Object country;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public State(Integer iD, Object name, Object code, Object country) {
        this.iD = iD;
        this.name = name;
        this.code = code;
        this.country = country;
    }

    @Ignore
    public State(Object name) {
        this.name = name;
    }
}
