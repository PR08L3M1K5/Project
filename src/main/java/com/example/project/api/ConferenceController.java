package com.example.project.api;

import com.example.project.model.*;
import com.example.project.service.LectureService;
import com.example.project.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
        private   LectureService lectureService;



    @Autowired
        private UsersService usersService;

    @GetMapping("/plan")
    public List<Lecture> getPlan()
    {
        return lectureService.getLectures();


    }

    @GetMapping("/lectures")
    public List<UserPercentage> getLectures()
    {
        return  lectureService.getLecturePercentage();
    }

    @GetMapping("/topics")
    public List<UserPercentage> getPaths()
    {
        return  lectureService.getTopicPercentage();

    }



    @PostMapping("/signup")
    public ObjectNode singUp(@RequestBody AddLecture addLecture) throws IOException {


        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("response:",lectureService.signUp(addLecture));
        return objectNode;

    }







}
