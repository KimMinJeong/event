package com.dots.event_api.dao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSn;
    private String userName;
    private String email;
    private String phoneNo;
    private String regDt;
    private String updDt;

    public TbUser() { }

    public TbUser(String userName, String email, String phoneNo) {}

    public TbUser(String userName, String email, String phoneNo, String regDt, String updDt) {
        this.userName = userName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.regDt = regDt;
        this.updDt = updDt;
    }


}
