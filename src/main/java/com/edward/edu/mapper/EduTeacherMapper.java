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

    int totalRowsNum(@Param("eduTeacher") EduTeacher eduTeacher); //查找条件下的总讲师数

    List<EduTeacher> currentPageTeacher(@Param("index") Integer index, @Param("limit") Integer limit, @Param("eduTeacher") EduTeacher eduTeacher); //返回当前页的讲师list集合

    int deleteTeacherById(int deleteId);
}
