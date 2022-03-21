package com.edward.edu.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

public class EduLog {
    private Integer id;
    private String username;
    private String option;
    private Date recordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "EduLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", option='" + option + '\'' +
                ", recordTime=" + recordTime +
                '}';
    }
}
