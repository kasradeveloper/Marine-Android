package com.base.base_app.data.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platform {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("LookupCategory")
    @Expose
    private Object lookupCategory;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("OrderIndex")
    @Expose
    private Integer orderIndex;
    @SerializedName("Color")
    @Expose
    private Object color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getLookupCategory() {
        return lookupCategory;
    }

    public void setLookupCategory(Object lookupCategory) {
        this.lookupCategory = lookupCategory;
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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }
}
