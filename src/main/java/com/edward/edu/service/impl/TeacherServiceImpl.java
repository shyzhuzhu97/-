package com.edward.edu.service.impl;


import com.edward.edu.bean.EduTeacher;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduTeacherMapper;
import com.edward.edu.service.TeacherService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
//@Transactional(isolation = Isolation.REPEATABLE_READ ) 设置事务隔离级别与传播行为，默认为REPEATABLE_READ
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    @Override
    public List<EduTeacher> findFourTeacher() {
        List<EduTeacher> teacherAll = eduTeacherMapper.findFourTeacher();
        return teacherAll;
    }

    @Override
    public EduTeacher findTeacherById(Integer teacherId) {
        EduTeacher teacherById = eduTeacherMapper.findTeacherById(teacherId);
        return teacherById;
    }

    @Override
    public int addTeacher(EduTeacher eduTeacher) {
        Date date = new Date();
        eduTeacher.setGmtCreated(date);
        eduTeacher.setGmtModified(date);
        int i = eduTeacherMapper.addTeacher(eduTeacher);
        if (i <= 0) {
            throw new EduException("添加讲师失败");
        }
        return i;
    }
}
