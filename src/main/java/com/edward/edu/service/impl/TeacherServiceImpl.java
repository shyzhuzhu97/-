package com.edward.edu.service.impl;


import com.edward.edu.bean.EduTeacher;
import com.edward.edu.constant.EduConstant;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduTeacherMapper;
import com.edward.edu.service.TeacherService;
import com.edward.edu.utils.UploadUtils;
import com.edward.edu.vo.EduResult;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public EduResult uploadAvatar(MultipartFile file) {
        File dateFolder = UploadUtils.getDateFolderRoot();
        if (!dateFolder.exists()) { //判断文件夹是否存在，如果不存在就创建这个文件夹
            dateFolder.mkdir();
        }
        //代码到这里一定有文件夹了
        String imgName = UploadUtils.getImgName(file.getOriginalFilename());
        //得到文件名称
        try {
            file.transferTo(new File(dateFolder,imgName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new EduException("上传图片失败");
        }
        return EduResult.ok("imgPath",EduConstant.HOST+":8080/"+UploadUtils.getDateFolder()+"/"+imgName);
    }
}
