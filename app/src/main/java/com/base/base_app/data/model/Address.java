package com.base.base_app.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("Locale")
    @Expose
    private String locale;
    @SerializedName("Direction")
    @Expose
    private String direction;
    @SerializedName("WorkperiodType")
    @Expose
    private String workPeriodType;
    @SerializedName("PersonnelCode")
    @Expose
    private String personnelCode;
    @SerializedName("ImageName")
    @Expose
    private String ImageName;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Address(String locale) {
        this.locale = locale;
    }

    public Address() {
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getWorkPeriodType() {
        return workPeriodType;
    }

    public void setWorkPeriodType(String workPeriodType) {
        this.workPeriodType = workPeriodType;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }
}
