package com.dots.event_api.service;

import com.dots.event_api.dao.domain.TbUser;
import com.dots.event_api.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public TbUser register(TbUser user) {
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
}
