package com.mybatis3.domain;

import java.util.Date;

/**
 * Student domain for mybatis
 * Created by noprom on 2/2/16.
 */
public class Student {

    private Integer studId;
    private String name;
    private String email;
    private Date dob;

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
