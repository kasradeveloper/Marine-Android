package com.base.base_app.data.model.SubPerson;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kasra.atency.data.network.model.performance.day.Code;
import com.kasra.atency.data.network.model.workplace.WorkplaceModel;

@Entity(tableName = "personnel_table")
public class SubPersonResponseModel {
    @PrimaryKey
    @NonNull
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("PersonnelCode")
    @Expose
    private String personnelCode;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Code")
    @Expose
    private Code code;
    @SerializedName("AtendanceLogTime")
    @Expose
    private String attendanceLogTime;
    @SerializedName("ImageName")
    @Expose
    private String imageName;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("IsDefaultAvatar")
    @Expose
    private boolean isDefaultAvatar;
    @SerializedName("Workplace")
    @Expose
    private WorkplaceModel workPlace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getAttendanceLogTime() {
        return attendanceLogTime;
    }

    public void setAttendanceLogTime(String atendanceLogTime) {
        this.attendanceLogTime = atendanceLogTime;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isDefaultAvatar() {
        return isDefaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        isDefaultAvatar = defaultAvatar;
    }


    public WorkplaceModel getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkplaceModel workPlace) {
        this.workPlace = workPlace;
    }

}
