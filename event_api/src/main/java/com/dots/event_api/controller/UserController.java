package com.dots.event_api.controller;

import com.dots.event_api.dao.domain.TbUser;
import com.dots.event_api.dao.repository.UserRepository;
import com.dots.event_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<TbUser> register(TbUser tbUser) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String nowTime = format.format(time);

        tbUser.setRegDt(nowTime);
        tbUser.setUpdDt(nowTime);

        return new ResponseEntity<TbUser>(userService.register(tbUser), HttpStatus.OK);
    }

    @GetMapping
    public Iterable<TbUser> list() {
        return userRepository.findAll();
    }



   /* @GetMapping("/test")
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
    */
}
