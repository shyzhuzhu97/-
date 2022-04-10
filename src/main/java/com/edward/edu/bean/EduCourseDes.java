package com.edward.edu.bean;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class EduCourseDes {
    private Integer id;
    private Date gmtCreated;
    private Date gmtModified;
    @NotBlank(message = "课程描述不能为空")
    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "EduCourseDes{" +
                "id=" + id +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", des='" + des + '\'' +
                '}';
    }
}
