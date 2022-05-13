package com.example.project.model;

public class UserPercentage {
    public  String name;
   public Double userPercentage;

    public UserPercentage(String name, Double userPercentage) {
        this.name = name;
        this.userPercentage = userPercentage;
    }

    public UserPercentage(String name)
    {
        this.name=name;
        this.userPercentage=0.0;
    }


    public void setPercentage(Double x)
    {
        this.userPercentage=this.userPercentage/x;
    }
    public void increment()
    {
        this.userPercentage++;
    }

    public Double getUserPercentage() {
        return userPercentage;
    }
}
