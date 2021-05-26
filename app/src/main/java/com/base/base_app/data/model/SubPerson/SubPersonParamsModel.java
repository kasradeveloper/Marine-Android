package com.base.base_app.data.model.SubPerson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubPersonParamsModel {

    @SerializedName("Id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubPersonParamsModel(String id) {
        this.id = id;
    }
}
