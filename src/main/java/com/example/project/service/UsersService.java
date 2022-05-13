package com.example.project.service;

import com.example.project.model.AddLecture;
import com.example.project.model.Lecture;
import com.example.project.model.User;

import java.util.List;

public interface UsersService {
   List<User> getUsers();


    boolean updateUser(User user);


    boolean signIn(User user, Lecture lecture);
     boolean exist(int id);

     List<Lecture> getUserLectures(String login);

    boolean deleteLecture(AddLecture addLecture);



}
