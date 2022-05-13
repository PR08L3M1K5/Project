package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    @ManyToMany
    @JoinTable(
            name = "sign_lectures",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="lecture_id")

    )




    private List<Lecture> signLectures = new ArrayList<>();



    public boolean checkLecture(char code)
    {
        for (Lecture l: signLectures
             ) {
            if(code == l.getCode())
            {
                return true;
            }
        }
        return false;
    }


    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addLecture(Lecture lecture)
    {
        signLectures.add(lecture);
    }

    public void deleteLecture(Lecture lecture) {signLectures.remove(lecture);}
    @JsonIgnore
    public Set<String> getTopics()
    {
        Set<String> topics= new HashSet<>();
        for(Lecture l:signLectures)
        {
            topics.add(l.getTopic());
        }
        return topics;

    }



    @Override
    public boolean equals(Object o)
    {
        if(o==this)
        {
            return true;
        }
        User x = (User) o;

        return this.getEmail().compareTo(x.getEmail())==0;

    }





    public static  void sendEmail(String login,String description) throws IOException
    {
        String date = new Date().toString();
        String message="login: "+ login+" date: "+  date+ " description: "+description;
        try(BufferedWriter locFile =new BufferedWriter( new FileWriter("email_updates.txt",true)))
        {

            locFile.write(message);
            locFile.newLine();
        }


    }


}