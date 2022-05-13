package com.example.project.api;

import com.example.project.model.AddLecture;
import com.example.project.model.Lecture;
import com.example.project.model.User;
import com.example.project.service.LectureService;
import com.example.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


   @Autowired
   private UsersService usersService;

   @Autowired
   private LectureService lectureService;



    @GetMapping("/e")
    public List<User> getUSers1()
    {
        return getUSers1();
    }





    @GetMapping
    public List<User> getUsers()
    {
        return usersService.getUsers();
    }

    @GetMapping("/{login}")
    public List<Lecture> getUser(@PathVariable("login") String login)
    {

      return   usersService.getUserLectures(login);

    }

    @PutMapping("/update")
    public boolean updateEmail(@RequestBody User user)  {

      //  User.sendEmail(user.getEmail());
        return usersService.updateUser(user);

    }

    @DeleteMapping("/cancel")
    public boolean deleteLecture(@RequestBody AddLecture addLecture)
    {



     //

            return usersService.deleteLecture(addLecture);
    }














}
