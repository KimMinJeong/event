package com.dots.event_api.dao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSn;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String phoneNo;

    private String email;

    @Column(nullable = false)
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
