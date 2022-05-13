package com.example.project.service;

import com.example.project.model.*;
import com.example.project.repository.LectureRepository;
import com.example.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {


    private  UsersService usersService;
    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }
    @Override
    public Lecture getLectureById(int id) {
        return lectureRepository.getById(id);
    }

    @Override
    public List<UserPercentage> getLecturePercentage() {
        List<UserPercentage> list = new ArrayList<>();
        for(Lecture l: lectureRepository.findAll())
        {
            list.add(new UserPercentage(l.getDescription(), Double.valueOf(l.getUsersList().size())/ Double.valueOf(usersRepository.count())));
        }
        list.sort(Comparator.comparingDouble(UserPercentage::getUserPercentage).reversed());
        return list;

    }

    @Override
    public List<UserPercentage> getTopicPercentage() {

        List<UserPercentage> list = new ArrayList<>();
        UserPercentage java = new UserPercentage("Java");
        UserPercentage c = new UserPercentage("C#");
        UserPercentage haskell = new UserPercentage("Haskell");


        for(User u : usersRepository.findAll() )
        {
            for(String t :u.getTopics())
            {
                switch (t)
                {
                    case "Java":
                        java.increment();
                        break;
                    case "C#":
                        c.increment();
                        break;
                    case "Haskell":
                        haskell.increment();
                        break;
                    default:
                        break;
                }
            }


        }
        java.setPercentage(Double.valueOf(usersRepository.count()));
        c.setPercentage(Double.valueOf(usersRepository.count()));
        haskell.setPercentage(Double.valueOf(usersRepository.count()));
        list.add(java);
        list.add(c);
        list.add(haskell);
        list.sort(Comparator.comparingDouble(UserPercentage::getUserPercentage).reversed());
        return list;
    }




   public String signUp(AddLecture addLecture) throws IOException {

        Lecture lecture = lectureRepository.getById(addLecture.getLecture());

       if (usersRepository.findUserByLogin(addLecture.getUser().getLogin())!=null) {

           User user = usersRepository.findUserByLogin(addLecture.getUser().getLogin());

           if (user.equals(addLecture.getUser())) {
                if(lecture.getUsersList().size()<=4)
                {
                    if(!user.checkLecture(lecture.getCode()))
                    {
                       // usersService.signIn(user,lecture);
                        user.addLecture(lecture);

                        usersRepository.save(user);
                        user.sendEmail(user.getLogin(),lecture.getDescription());
                        return "added";
                    }else {
                        return "u dont have time";
                    }
                }
                else {
                    return "there is no place";
                }
           }
           else {
               return "sorry we have user with this email";
           }


       }
       else
       {
           if(lecture.getUsersList().size()<=4)
           {
           //    usersService.signIn(addLecture.getUser(),lecture);
               addLecture.getUser().addLecture(lecture);
            //   usersRepository.findUserByLogin(addLecture.getUser().getLogin()).addLecture(lecture);

               usersRepository.save(addLecture.getUser());
               usersRepository.findUserByLogin(addLecture.getUser().getLogin()).sendEmail(addLecture.getUser().getLogin(),lecture.getDescription());
               return "added";
           }else
           {
               return "there is no place";
           }
       }

   }







}
