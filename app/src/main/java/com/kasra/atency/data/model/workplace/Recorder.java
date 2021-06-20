package com.kasra.atency.data.model.workplace;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recorder {

    @SerializedName("Id")
    @Expose
    private int idRecorder;
    @ColumnInfo(name = "workplaceId")
    private int workplaceId;
    @SerializedName("Brand")
    @Expose
    private Brand brand;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Workplace")
    @Expose
    private WorkplaceModel workplace;
    @Embedded(prefix = "types_")
    @SerializedName("Type")
    @Expose
    private Type type;
    @SerializedName("Tenant")
    @Expose
    private Object tenant;
    @SerializedName("ExternalSystemMap")
    @Expose
    private String externalSystemMap;

    public int getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(int workplaceId) {
        this.workplaceId = workplaceId;
    }

    public int getIdRecorder() {
        return idRecorder;
    }

    public void setIdRecorder(int id) {
        this.idRecorder = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkplaceModel getWorkplace() {
        return workplace;
    }

    public void setWorkplace(WorkplaceModel workplace) {
        this.workplace = workplace;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getTenant() {
        return tenant;
    }

    public void setTenant(Object tenant) {
        this.tenant = tenant;
    }

    public Recorder(int idRecorder) {
        this.idRecorder = idRecorder;
    }

    public String getExternalSystemMap() {
        return externalSystemMap;
    }

    public void setExternalSystemMap(String externalSystemMap) {
        this.externalSystemMap = externalSystemMap;
    }
}
