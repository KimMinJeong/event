package com.dots.event_api.dao.domain;

import java.sql.Timestamp;

public class TBUser {
    private int user_sn;
    private String user_name;
    private String user_email;
    private String user_cellphone;
    private String user_ipaddress;
    private Timestamp reg_dt;
    private Timestamp upd_dt;

    public int getUser_sn() {
        return user_sn;
    }

    public void setUser_sn(int user_sn) {
        this.user_sn = user_sn;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_cellphone() {
        return user_cellphone;
    }

    public void setUser_cellphone(String user_cellphone) {
        this.user_cellphone = user_cellphone;
    }

    public String getUser_ipaddress() {
        return user_ipaddress;
    }

    public void setUser_ipaddress(String user_ipaddress) {
        this.user_ipaddress = user_ipaddress;
    }

    public Timestamp getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Timestamp reg_dt) {
        this.reg_dt = reg_dt;
    }

    public Timestamp getUpd_dt() {
        return upd_dt;
    }

    public void setUpd_dt(Timestamp upd_dt) {
        this.upd_dt = upd_dt;
    }

    @Override
    public String toString() {
        return "User[sn=" +user_sn+ "user_name" +user_name ;
    }

}
