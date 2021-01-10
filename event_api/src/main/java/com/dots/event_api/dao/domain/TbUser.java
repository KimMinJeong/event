package com.dots.event_api.dao.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("N") //default N
    private String seminarYn;

    @Column(nullable = false)
    private String regDt;

    private String updDt;

    public TbUser() { }

    public TbUser(String userName, String phoneNo, String email, String seminar_yn) {}

    public TbUser(String userName, String phoneNo, String email, String seminar_yn, String regDt, String updDt) {
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.seminarYn = seminar_yn;
        this.regDt = regDt;
        this.updDt = updDt;
    }


}
