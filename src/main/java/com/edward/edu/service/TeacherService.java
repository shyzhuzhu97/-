package com.edward.edu.service;


import com.edward.edu.bean.EduTeacher;

import java.util.List;

public interface TeacherService {
    List<EduTeacher> findFourTeacher();

    EduTeacher findTeacherById(Integer teacherId);

    int addTeacher(EduTeacher eduTeacher);
}
