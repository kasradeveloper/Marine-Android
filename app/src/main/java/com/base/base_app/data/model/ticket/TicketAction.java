package com.base.base_app.data.model.ticket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kasra.atency.data.network.model.message.Type;
import com.kasra.atency.data.network.model.message.User;

public class TicketAction {
    @SerializedName("Ticket")
    @Expose
    TicketItem ticket;
    @SerializedName("TrackingCode")
    @Expose
    String trackingCode;
    @SerializedName("Type")
    @Expose
    Type actionType;
    @SerializedName("Value")
    @Expose
    String Value;
    @SerializedName("Owner")
    @Expose
    User owner;
    @SerializedName("RegisteredBy")
    @Expose
    User registeredBy;
    @SerializedName("ModifiedBy")
    @Expose
    User modifiedBy;
    @SerializedName("RegisteredOn")
    @Expose
    String registeredOn;
    @SerializedName("ModifiedOn")
    @Expose
    String modifiedOn;
    @SerializedName("IsHeader")
    @Expose
    boolean isHeader;

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public TicketAction(String value, String registeredOn) {
        Value = value;
        this.registeredOn = registeredOn;
    }

    public TicketItem getTicket() {
        return ticket;
    }

    public void setTicket(TicketItem ticket) {
        this.ticket = ticket;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public Type getActionType() {
        return actionType;
    }

    public void setActionType(Type actionType) {
        this.actionType = actionType;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(User registeredBy) {
        this.registeredBy = registeredBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
