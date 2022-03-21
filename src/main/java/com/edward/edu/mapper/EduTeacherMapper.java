package com.edward.edu.mapper;

import com.edward.edu.bean.EduTeacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface EduTeacherMapper {

    List<EduTeacher> findTeacherAll();

    EduTeacher findTeacherById(Integer teacherId);

    List<EduTeacher> findFourTeacher();

    int addTeacher(EduTeacher eduTeacher);
}
