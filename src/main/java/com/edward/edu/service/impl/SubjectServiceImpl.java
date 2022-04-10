package com.edward.edu.service.impl;

import com.edward.edu.bean.EduSubject;
import com.edward.edu.mapper.EduSubjectMapper;
import com.edward.edu.service.SubjectService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private EduSubjectMapper eduSubjectMapper;

    @Override
    public EduResult getSubjectOne() {
        List<EduSubject> subjectList = eduSubjectMapper.getSubjectOne();
        return EduResult.ok().data("subjectList",subjectList);
    }

    @Override
    public EduResult getSubjectTwo(Integer id) {
        List<EduSubject> subjectList = eduSubjectMapper.getSubjectTwo(id);
        return EduResult.ok().data("subjectList",subjectList);
    }

    @Override
    public EduResult querySubject(String title) {
        List<EduSubject> subjectList = eduSubjectMapper.querySubject(title);
        return EduResult.ok().data("subjectList",subjectList);
    }
}
