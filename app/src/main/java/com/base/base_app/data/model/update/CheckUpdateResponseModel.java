package com.base.base_app.data.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.internal.platform.Platform;

public class CheckUpdateResponseModel {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Platform")
    @Expose
    private Platform platform;
    @SerializedName("MinimumCompatibleVersion")
    @Expose
    private MinimumCompatibleVersion minimumCompatibleVersion;
    @SerializedName("Changelog")
    @Expose
    private Object changelog;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("VersionNumber")
    @Expose
    private String versionNumber;
    @SerializedName("VersionCode")
    @Expose
    private Integer versionCode;
    @SerializedName("RegistrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("UpdateType")
    @Expose
    private UpdateType updateType;
    @SerializedName("StoreUrl")
    @Expose
    private String storeURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public MinimumCompatibleVersion getMinimumCompatibleVersion() {
        return minimumCompatibleVersion;
    }

    public void setMinimumCompatibleVersion(MinimumCompatibleVersion minimumCompatibleVersion) {
        this.minimumCompatibleVersion = minimumCompatibleVersion;
    }

    public Object getChangelog() {
        return changelog;
    }

    public void setChangelog(Object changelog) {
        this.changelog = changelog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public String getStoreURL() {
        return storeURL;
    }

    public void setStoreURL(String storeURL) {
        this.storeURL = storeURL;
    }
}
