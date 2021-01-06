package com.gucarsoft.egitimprojesi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogModel {

    private int id;
    private String title;
    private String detail;
    private String date;

    public LogModel(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.detail = builder.title;
        String pattern = "MM/dd/yyyy HH:mm";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        this.date = df.format(today);
    }

    public LogModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public static class Builder {

        private int id;
        private String title;
        private String detail;
        private String date;

        public Builder() {
            String pattern = "MM/dd/yyyy HH:mm";
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();
            this.date = df.format(today);
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder dateTime(String date) {
            this.date = date;
            return this;
        }

        public LogModel build() {
            LogModel entity = new LogModel(this);
            return entity;
        }

    }

}
