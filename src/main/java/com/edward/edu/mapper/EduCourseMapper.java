package com.edward.edu.mapper;

import com.edward.edu.bean.EduCourse;
import com.edward.edu.bean.EduCourseDes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EduCourseMapper {
    int addCourse(EduCourse eduCourse);

    int addCourseDes(EduCourseDes eduCourseDes);

    EduCourse getCourseById(Integer id);

    EduCourseDes getCourseDesById(Integer id);

    int updateCourse(EduCourse eduCourse);

    int updateCourseDes(EduCourseDes eduCourseDes);
}
