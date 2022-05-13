package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;
    private String description;

    private String code;

    private  String start;
    private  String end;
    @JsonIgnore
    public char getCode()

    {
        return code.charAt(1);

    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @ManyToMany(mappedBy = "signLectures")
    private List<User> userList = new ArrayList<>();

    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonIgnore
    public List<User> getUsersList() {
        return userList;
    }

    public void setUsersList(List<User> userList) {
        this.userList = userList;
    }





    public boolean userExist(User user)
    {
        if(userList.contains(user))
        {
            return true;
        }else
        {
            return false;
        }

    }


}
