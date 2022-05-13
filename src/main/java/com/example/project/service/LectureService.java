package com.example.project.service;

import com.example.project.model.AddLecture;
import com.example.project.model.Lecture;
import com.example.project.model.UserPercentage;

import java.io.IOException;
import java.util.List;

public interface LectureService  {
    List<Lecture> getLectures();
    Lecture getLectureById(int id);

    List<UserPercentage> getLecturePercentage();


    List<UserPercentage> getTopicPercentage();


    String signUp(AddLecture addLecture) throws IOException;
}
