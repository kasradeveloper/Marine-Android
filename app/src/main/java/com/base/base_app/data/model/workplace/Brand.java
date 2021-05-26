package com.base.base_app.data.model.workplace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand {
    @SerializedName("Id")
    @Expose
    private Object id;
    @SerializedName("LookupCategory")
    @Expose
    private Object lookupCategory;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Name")
    @Expose
    private Object name;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("OrderIndex")
    @Expose
    private Integer orderIndex;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
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

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
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

    public Brand(Object id, Object lookupCategory, String value, Object name, Object description, Integer orderIndex) {
        this.id = id;
        this.lookupCategory = lookupCategory;
        this.value = value;
        this.name = name;
        this.description = description;
        this.orderIndex = orderIndex;
    }
}
