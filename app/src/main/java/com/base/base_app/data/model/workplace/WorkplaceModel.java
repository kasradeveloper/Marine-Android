package com.base.base_app.data.model.workplace;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "workplace")
public class WorkplaceModel {

    @PrimaryKey
    @NonNull
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Tenant")
    @Expose
    private Object tenant;
    @SerializedName("Address")
    @Expose
    private Object address;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("Langitude")
    @Expose
    private Double langitude;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Country")
    @Expose
    private Country country;
    @SerializedName("State")
    @Expose
    private State state;
    @SerializedName("Radius")
    @Expose
    private Integer radius;
    @SerializedName("TimeZone")
    @Expose
    private Integer timeZone;
    @SerializedName("Personnels")
    @Expose
    private Object personnels;
    @SerializedName("Type")
    @Expose
    private Type type;
    @SerializedName("Recorders")
    @Expose
    private List<Recorder> recorders = null;
    @SerializedName("distance")
    @Expose
    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer Id) {
        this.iD = Id;
    }

    public Object getTenant() {
        return tenant;
    }

    public void setTenant(Object tenant) {
        this.tenant = tenant;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Double getLangitude() {
        return langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }


    public Object getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Object personnels) {
        this.personnels = personnels;
    }

    public List<Recorder> getRecorders() {
        return recorders;
    }

    public void setRecorders(List<Recorder> recorders) {
        this.recorders = recorders;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Integer timeZone) {
        this.timeZone = timeZone;
    }

}