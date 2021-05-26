package com.base.base_app.data.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateType {

    @SerializedName("Id")
    @Expose
    private int id;
    @SerializedName("OrderIndex")
    @Expose
    private int orderIndex;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Name")
    @Expose
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
