package com.example.project.repository;

import com.example.project.model.Lecture;
import com.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Integer> {


    List<Lecture> findLectureByUserList(User user);




}
