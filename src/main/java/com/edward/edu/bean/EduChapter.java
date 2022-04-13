package com.edward.edu.bean;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class EduChapter {
    private Integer id;
    //这里为什么不做jsr303数据校验非空呢 好像notBlank只能校验字符串 不能校验int类型
    private Integer courseId;
    @NotBlank(message = "章节名称不能为空")
    private String title;
    private String sort;
    private Date gmtCreated;
    private Date gmtModified;
    //一个章节下面 有多个小节 所以是一个章节对象 有一个集合小节对象
    private List<EduVideo> videoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public List<EduVideo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<EduVideo> videoList) {
        this.videoList = videoList;
    }

    @Override
    public String toString() {
        return "EduChapter{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", videoList=" + videoList +
                '}';
    }
}
