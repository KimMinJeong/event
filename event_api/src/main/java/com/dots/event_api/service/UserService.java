package com.dots.event_api.service;

import com.dots.event_api.dao.domain.TbUser;
import com.dots.event_api.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public TbUser register(String userName, String phoneNo, String email, String seminarYn, String nowTime) {

        TbUser user = new TbUser();
        user.setUserName(userName);
        user.setPhoneNo(phoneNo);
        user.setEmail(email);
        user.setSeminarYn(seminarYn);
        user.setRegDt(nowTime);
        user.setUpdDt(nowTime);

        userRepository.save(user);

        return user;
    }

    public List<TbUser> findAll() {
        List<TbUser> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));

        return users;
    }

    public Optional<TbUser> findByUserSn(Long userSn) {
        Optional<TbUser> user = userRepository.findByUserSn(userSn);

        return user;
    }

    public List<TbUser> findByUserNameAndPhoneNo(String userName, String phoneNo) {
        List<TbUser> user = userRepository.findAllByUserNameAndPhoneNo(userName, phoneNo);

        return user;
    }
}
