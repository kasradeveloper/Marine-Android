package com.kasra.atency.data.model.workplace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OsmSearch {
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lng;
    @SerializedName("display_name")
    @Expose
    private String name;
    @SerializedName("icon")
    @Expose
    private String iconAddress;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }
}
