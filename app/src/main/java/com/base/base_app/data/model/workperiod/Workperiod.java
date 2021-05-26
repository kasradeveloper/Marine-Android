package com.base.base_app.data.model.workperiod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Workperiod {
    @SerializedName("IsCurrentWorkperiod")
    @Expose
    private Boolean isCurrentWorkperiod;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("OrderIndex")
    @Expose
    private Integer orderIndex;
    @SerializedName("IsLock")
    @Expose
    private boolean lock;

    private boolean isSelected=false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Boolean getIsCurrentWorkperiod() {
        return isCurrentWorkperiod;
    }

    public void setIsCurrentWorkperiod(Boolean isCurrentWorkperiod) {
        this.isCurrentWorkperiod = isCurrentWorkperiod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
