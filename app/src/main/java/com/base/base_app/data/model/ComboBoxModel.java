package com.base.base_app.data.model;

import com.kasra.atency.data.network.model.request.RequestClass;
import com.kasra.atency.data.network.model.workplace.WorkplaceModel;

public class ComboBoxModel {

    private String value;
    private String name;
    private boolean check=false;
    private RequestClass requestClass;
    private WorkplaceModel workplaceModel;

    public ComboBoxModel(String name) {
        this.name = name;
    }

    public ComboBoxModel(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public ComboBoxModel(String value, String name, RequestClass requestClass) {
        this.value = value;
        this.name = name;
        this.requestClass = requestClass;
    }

    public ComboBoxModel(String name, WorkplaceModel model) {
        this.name = name;
        this.workplaceModel = model;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public RequestClass getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(RequestClass requestClass) {
        this.requestClass = requestClass;
    }

    public WorkplaceModel getWorkplaceModel() {
        return workplaceModel;
    }

    public void setWorkplaceModel(WorkplaceModel workplaceModel) {
        this.workplaceModel = workplaceModel;
    }
}
