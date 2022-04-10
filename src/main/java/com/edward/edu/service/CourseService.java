package com.edward.edu.service;

import com.edward.edu.vo.EduResult;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {
    EduResult uploadImg(MultipartFile file);
}
