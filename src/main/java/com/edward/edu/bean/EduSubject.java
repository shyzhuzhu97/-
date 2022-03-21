package com.edward.edu.bean;

import java.io.Serializable;
import java.util.Date;

public class EduSubject implements Serializable {
    private Integer id;
    private String title;
    private Integer parentId;
    private Integer sort;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "EduSubject [id=" + id + ", title=" + title + ", parentId=" + parentId + ", sort=" + sort
                + ", isDeleted=" + isDeleted + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }


}
