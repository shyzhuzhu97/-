package com.edward.edu.vo;

import com.edward.edu.bean.EduCourse;
import com.edward.edu.bean.EduCourseDes;

public class CourseVo {
    private EduCourse eduCourse;
    private EduCourseDes eduCourseDes;

    public EduCourse getEduCourse() {
        return eduCourse;
    }

    public void setEduCourse(EduCourse eduCourse) {
        this.eduCourse = eduCourse;
    }

    public EduCourseDes getEduCourseDes() {
        return eduCourseDes;
    }

    public void setEduCourseDes(EduCourseDes eduCourseDes) {
        this.eduCourseDes = eduCourseDes;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "eduCourse=" + eduCourse +
                ", eduCourseDes=" + eduCourseDes +
                '}';
    }
}
