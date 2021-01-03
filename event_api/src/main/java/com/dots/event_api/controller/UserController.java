package com.dots.event_api.controller;

import com.dots.event_api.dao.domain.TBUser;
import com.dots.event_api.dao.persistence.TBUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class UserController {
    @Autowired
    private TBUserDao tbUserDao;

    @GetMapping("/test")
    public TBUser userTest(){
        TBUser testUser = new TBUser();
        testUser.setUser_sn(1);
        testUser.setUser_email("sinred123@gmail.com");
        testUser.setUser_name("Kim");

        return testUser;
    }

    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return String.format("%s %s", tbUserDao.selectOne(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
