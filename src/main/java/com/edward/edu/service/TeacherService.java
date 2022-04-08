package com.edward.edu.service;


import com.edward.edu.bean.EduTeacher;
import com.edward.edu.vo.EduResult;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

public interface TeacherService {
    List<EduTeacher> findFourTeacher();

    EduResult findTeacherById(Integer teacherId);

    int addTeacher(EduTeacher eduTeacher);

    EduResult uploadAvatar(MultipartFile file);

    int deleteTeacher(List<Integer> ids);

    int updateTeacher(EduTeacher eduTeacher);

    EduResult conditionPageQuery(Integer currentPage, Integer limit, EduTeacher eduTeacher);//多条件分页查询讲师

    EduResult deleteTeacherById(int deleteId);
}
