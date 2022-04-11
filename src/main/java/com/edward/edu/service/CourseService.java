package com.edward.edu.service;

import com.edward.edu.vo.CourseVo;
import com.edward.edu.vo.EduResult;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {
    EduResult uploadImg(MultipartFile file);

    EduResult addCourse(CourseVo course);

    EduResult getCourseById(Integer id);

    EduResult updateCourse(CourseVo course);
}
