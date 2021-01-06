package com.gucarsoft.egitimprojesi.model;

public class SoruModel {

    private int id;
    private String name;
    private int goal;
    private int done;

    public SoruModel(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.goal=builder.goal;
        this.done=builder.done;
    }

    public SoruModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public static class Builder{

        private int id;
        private String name;
        private int goal;
        private int done;

        public Builder(){}

        public Builder getId(int id) {
            this.id=id;
            return this;
        }

        public Builder name(String name) {
            this.name=name;
            return this;
        }

        public Builder goal(int goal) {
            this.goal=goal;
            return this;
        }

        public Builder done(int done) {
            this.done=done;
            return this;
        }

        public SoruModel build(){
            SoruModel entity= new SoruModel(this);
            return entity;
        }

    }

}
