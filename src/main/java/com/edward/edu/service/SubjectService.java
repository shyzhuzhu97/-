package com.edward.edu.service;

import com.edward.edu.vo.EduResult;

public interface SubjectService {

    EduResult getSubjectOne();

    EduResult getSubjectTwo(Integer id);

    EduResult querySubject(String title);
}
