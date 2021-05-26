package com.base.base_app.data.model.ticket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddActionResponse {
    @SerializedName("Data")
    @Expose
    TicketItem ticketItem;

    public TicketItem getTicketItem() {
        return ticketItem;
    }

    public void setTicketItem(TicketItem ticketItem) {
        this.ticketItem = ticketItem;
    }
}
