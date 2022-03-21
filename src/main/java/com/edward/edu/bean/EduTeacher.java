package com.edward.edu.bean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class EduTeacher implements Serializable {
    private int id;
    @NotBlank(message = "教师名称不能为空！")
    private String name;
    private Integer sort;
    private Integer level;
    @NotBlank(message = "教师简介不能为空！")
    private String career;
    @NotBlank(message = "教师介绍不能为空！")
    private String intro;
    private String avatar; //可能出现空格 用.trim()去除
    private boolean isDeleted;
    private Date gmtCreated;
    private Date gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    } //可能出现空格 用.trim()去除

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    @Override
    public String toString() {
        return "EduTeacher [id=" + id + ", name=" + name + ", career=" + career + ", intro=" + intro + ", level="
                + level + ", avatar=" + avatar + ", sort=" + sort + ", isDeleted=" + isDeleted + ", gmtCreated="
                + gmtCreated + ", gmtModified=" + gmtModified + "]";
    }


}
