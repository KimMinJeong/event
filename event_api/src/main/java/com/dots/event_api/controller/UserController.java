package com.dots.event_api.controller;

import com.dots.event_api.dao.domain.TbUser;
import com.dots.event_api.dao.repository.UserRepository;
import com.dots.event_api.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserService userService;

    private UserRepository userRepository;

    //api cmd 기능
    @ResponseBody
    @RequestMapping(value="/api.do", produces = "application/text; charset=utf8")
    public String api(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String cmd = request.getParameter("cmd");

        if(cmd.equals("user_register")) {
            return register(request, response);
        }

        return null;
    }

    //등록
    @PostMapping
    private String register(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("userName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String nowTime = format.format(time);

        List<TbUser> list = userService.findByUserNameAndPhoneNo(userName, phoneNo);
        int count = list.size();

        JSONObject result = new JSONObject();

        if(count>0) {
            result.put("result_code", HttpStatus.TOO_MANY_REQUESTS);
            result.put("result_msg", "이미 등록하였습니다.");
        }else{
            if(userName.equals("") || userName.equals(null)){
                result.put("result_code", HttpStatus.NO_CONTENT);
                result.put("result_msg", "이름을 입력해주세요.");
            }else if(phoneNo.equals("") || phoneNo.equals(null)){
                result.put("result_code", HttpStatus.NO_CONTENT);
                result.put("result_msg", "휴대전화를 입력해주세요.");
            }else {
                userService.register(userName,
                        phoneNo,
                        email,
                        nowTime);

                result.put("result_code", HttpStatus.OK);
                result.put("result_msg", "등록완료되었습니다.");
            }
        }

        return result.toString();
    }

    //리스트
    @GetMapping
    public Iterable<TbUser> list() {
        return userRepository.findAll();
    }
}
