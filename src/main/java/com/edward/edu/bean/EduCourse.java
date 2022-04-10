package com.edward.edu.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class EduCourse {
    private Integer id;
    @NotNull(message = "课程所属讲师不能空")
    private Integer teacherId;
    @NotNull(message = "课程所属课程分类不能为空")
    private Integer subjectId;
    @NotNull(message = "课程所属课程分类不能为空")
    private Integer subjectParentId;
    @NotBlank(message = "课程名称不能为空")
    private String title;
    @Min(message = "课程价格必须为正数",value = 0)
    private BigDecimal price;
    @NotBlank(message = "课时数不能为空")
    private String lessonNum;
    @NotBlank(message = "课程封面不能为空")
    private String cover;
    private Long buyCount;
    private Long viewCount;
    private Long version;
    private String status;
    private Date gmtCreated;
    private Date gmtModified;
    private EduTeacher eduTeacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(Integer subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(String lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public EduTeacher getEduTeacher() {
        return eduTeacher;
    }

    public void setEduTeacher(EduTeacher eduTeacher) {
        this.eduTeacher = eduTeacher;
    }

    @Override
    public String toString() {
        return "EduCourse{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", subjectId=" + subjectId +
                ", subjectParentId=" + subjectParentId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", lessonNum='" + lessonNum + '\'' +
                ", cover='" + cover + '\'' +
                ", buyCount=" + buyCount +
                ", viewCount=" + viewCount +
                ", version=" + version +
                ", status='" + status + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                ", eduTeacher=" + eduTeacher +
                '}';
    }
}
