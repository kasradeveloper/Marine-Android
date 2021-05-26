package com.base.base_app.data.model;

public class MyTimeModel {

    int minutes;
    int hours;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public MyTimeModel(int minutes, int hours) {
        this.minutes = minutes;
        this.hours = hours;
    }
}
