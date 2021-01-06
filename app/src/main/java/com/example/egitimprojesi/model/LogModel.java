package com.example.egitimprojesi.model;

import java.util.Calendar;

public class LogModel {

    private int id;
    private String title;
    private String detail;
    private String date = Calendar.getInstance().getTime().toString();

    public LogModel(Builder builder){
        this.id=builder.id;
        this.title=builder.title;
        this.detail=builder.title;
        this.date=builder.date;
    }

    public LogModel(){
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


    public static class Builder{

        private int id;
        private String title;
        private String detail;
        private String date = Calendar.getInstance().getTime().toString();

        public Builder(){ }

        public Builder id(int id) {
            this.id=id;
            return this;
        }

        public Builder title(String title) {
            this.title=title;
            return this;
        }

        public Builder detail(String detail) {
            this.detail=detail;
            return this;
        }

        public Builder dateTime(String date) {
            this.date=date;
            return this;
        }

        public LogModel build() {
            LogModel entity = new LogModel(this);
            return entity;
        }

    }

}
