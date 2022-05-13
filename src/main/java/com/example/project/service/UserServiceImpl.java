package com.example.project.service;

import com.example.project.model.*;
import com.example.project.repository.LectureRepository;
import com.example.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional

public class UserServiceImpl implements UsersService{


    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private LectureRepository lectureRepository;
    @Override
    public List<User> getUsers() {

        System.out.println("eloszka");

        return usersRepository.findAll();

    }




    @Override
    public boolean updateUser(User user) {
        Optional<User> userDb = Optional.ofNullable(this.usersRepository.findUserByLogin(user.getLogin()));

        if(userDb.isPresent())
        {
            User userUpdate = userDb.get();
            userUpdate.setEmail(user.getEmail());
            usersRepository.save(userUpdate);
            return true;
        }else
        {
            return false;
        }

    }




    public boolean signIn(User user, Lecture lecture)
    {

        user.addLecture(lecture);

      usersRepository.save(user);

      return true;
    }

    public boolean exist(int id)
    {

        return usersRepository.existsById(id);

    }


    public List<Lecture> getUserLectures(String login)
    {

      return lectureRepository.findLectureByUserList(usersRepository.findUserByLogin(login));

    }

 public boolean deleteLecture(AddLecture addLecture)
    {
        usersRepository.findUserByLogin(addLecture.getUser().getLogin()).deleteLecture(lectureRepository.getById(addLecture.getLecture()));

        return true;
    }




}
