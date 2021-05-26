package com.base.base_app.data.model.workperiod;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "get_work_period")
public class GetAllWorkperiods {
    @SerializedName("Id")
    @Expose
    @NonNull
    @PrimaryKey
    private Integer id;
    @SerializedName("Workperiods")
    @Expose
    private List<Workperiod> workperiods = null;
    @SerializedName("CurrentWorkperiod")
    @Expose
    private Workperiod currentWorkperiod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Workperiod> getWorkperiods() {
        return workperiods;
    }

    public void setWorkperiods(List<Workperiod> workperiods) {
        this.workperiods = workperiods;
    }

    public Workperiod getCurrentWorkperiod() {
        return currentWorkperiod;
    }

    public void setCurrentWorkperiod(Workperiod currentWorkperiod) {
        this.currentWorkperiod = currentWorkperiod;
    }
}
