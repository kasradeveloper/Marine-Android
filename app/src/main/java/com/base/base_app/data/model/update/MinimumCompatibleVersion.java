package com.base.base_app.data.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MinimumCompatibleVersion {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Platform")
    @Expose
    private Platform platform;
    @SerializedName("MinimumCompatibleVersion")
    @Expose
    private Object minimumCompatibleVersion;
    @SerializedName("Changelog")
    @Expose
    private String changelog;
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
    private Object updateType;

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

    public Object getMinimumCompatibleVersion() {
        return minimumCompatibleVersion;
    }

    public void setMinimumCompatibleVersion(Object minimumCompatibleVersion) {
        this.minimumCompatibleVersion = minimumCompatibleVersion;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
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

    public Object getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Object updateType) {
        this.updateType = updateType;
    }
}
