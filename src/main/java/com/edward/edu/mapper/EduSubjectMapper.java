package com.edward.edu.mapper;

import com.edward.edu.bean.EduSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduSubjectMapper {


    EduSubject findSubjectByName(String subjectOneName);

    void addSubject(EduSubject subjectOne);

    List<EduSubject> findSubjectAll();

    EduSubject getTitleById(Integer parentId);

    List<EduSubject> getSubjectOne();

    List<EduSubject> getSubjectTwo(Integer id);

    List<EduSubject> querySubject(String title);
}
