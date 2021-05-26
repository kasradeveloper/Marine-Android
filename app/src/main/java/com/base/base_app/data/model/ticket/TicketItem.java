package com.base.base_app.data.model.ticket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kasra.atency.data.network.model.attendance.Tenant;
import com.kasra.atency.data.network.model.message.Type;
import com.kasra.atency.data.network.model.message.User;

import java.util.List;

public class TicketItem {

    @SerializedName("Id")
    @Expose
    String Id;
    @SerializedName("TrackingCode")
    @Expose
    String trackingCode;
    @SerializedName("Title")
    @Expose
    String title;
    @SerializedName("Priority")
    @Expose
    Type priority;
    @SerializedName("Category")
    @Expose
    Type category;
    @SerializedName("Tenant")
    @Expose
    Tenant tenant;
    @SerializedName("LastStatus")
    @Expose
    Type LastStatus;
    @SerializedName("RegisteredBy")
    @Expose
    User RegisteredBy;
    @SerializedName("RegisteredOn")
    @Expose
    String RegisteredOn;
    @SerializedName("ModifiedBy")
    @Expose
    User ModifiedBy;
    @SerializedName("LastModifiedDate")
    @Expose
    String ModifiedOn;
    @SerializedName("Actions")
    @Expose
    List<TicketAction> ticketActions;

    public TicketItem() {
    }
    public TicketItem(String id) {
        Id = id;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getPriority() {
        return priority;
    }

    public void setPriority(Type priority) {
        this.priority = priority;
    }

    public Type getCategory() {
        return category;
    }

    public void setCategory(Type category) {
        this.category = category;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Type getLastStatus() {
        return LastStatus;
    }

    public void setLastStatus(Type lastStatus) {
        LastStatus = lastStatus;
    }

    public User getRegisteredBy() {
        return RegisteredBy;
    }

    public void setRegisteredBy(User registeredBy) {
        RegisteredBy = registeredBy;
    }

    public String getRegisteredOn() {
        return RegisteredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        RegisteredOn = registeredOn;
    }

    public User getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return ModifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        ModifiedOn = modifiedOn;
    }

    public List<TicketAction> getTicketActions() {
        return ticketActions;
    }

    public void setTicketActions(List<TicketAction> ticketActions) {
        this.ticketActions = ticketActions;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
