package com.base.base_app.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_info")
public class UserInfo {
    @PrimaryKey
    @NonNull
    @SerializedName("sub")
    @Expose
    private String sub;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("given_name")
    @Expose
    private String givenName;
    @SerializedName("iss")
    @Expose
    private String iss;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("aud")
    @Expose
    private String aud;
    @SerializedName("preferred_username")
    @Expose
    private String personnelId;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }


    @Ignore
    public UserInfo() {
    }

    public UserInfo(@NonNull String sub, Address address) {
        this.sub = sub;
        this.address = address;
    }
}
