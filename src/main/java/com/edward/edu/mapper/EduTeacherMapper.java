package com.edward.edu.mapper;

import com.edward.edu.bean.EduTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EduTeacherMapper {

    List<EduTeacher> findTeacherAll();

    EduTeacher findTeacherById(Integer teacherId);

    List<EduTeacher> findFourTeacher();

    int addTeacher(EduTeacher eduTeacher);

    int deleteTeacher(@Param("ids") List<Integer> ids); //@Param 传参赋名

    int updateTeacher(EduTeacher eduTeacher);
}
