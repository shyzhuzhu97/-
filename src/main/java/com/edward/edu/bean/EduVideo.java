package com.edward.edu.bean;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class EduVideo {
    private Integer id;
    private Integer courseId;
    private Integer chapterId;
    private String title;
    @NotBlank(message = "小节视频url地址不能为空")
    private String videoSourceId;
    @NotBlank(message = "小节名称不能为空")
    private String videoOriginalName;
    private Long playCount;
    private Boolean isFree;
    private Long duration;
    private String status;
    private String size;
    private Long version;
    private Date gmtCreated;
    private Date gmtModified;
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

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

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoSourceId() {
        return videoSourceId;
    }

    public void setVideoSourceId(String videoSourceId) {
        this.videoSourceId = videoSourceId;
    }

    public String getVideoOriginalName() {
        return videoOriginalName;
    }

    public void setVideoOriginalName(String videoOriginalName) {
        this.videoOriginalName = videoOriginalName;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        return "EduVideo{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", chapterId=" + chapterId +
                ", title='" + title + '\'' +
                ", videoSourceId='" + videoSourceId + '\'' +
                ", videoOriginalName='" + videoOriginalName + '\'' +
                ", playCount=" + playCount +
                ", isFree=" + isFree +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", size='" + size + '\'' +
                ", version=" + version +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", sort='" + sort + '\'' +
                '}';
    }
}
