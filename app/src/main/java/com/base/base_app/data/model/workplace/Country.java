package com.base.base_app.data.model.workplace;

import androidx.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private Object name;
    @SerializedName("Code")
    @Expose
    private Object code;

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

    public Country(Integer iD, Object name, Object code) {
        this.iD = iD;
        this.name = name;
        this.code = code;
    }

    @Ignore
    public Country(Object name, Object code) {
        this.name = name;
        this.code = code;
    }

    public Country(Object code) {
        this.code = code;
    }
}
