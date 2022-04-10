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
    public EduResult findTeacherById(Integer teacherId) {
        EduTeacher teacher = eduTeacherMapper.findTeacherById(teacherId);
        if (teacher == null) {
            throw new EduException("查找失败请重试");

        }
        return EduResult.ok().data("teacher", teacher);
    }

    @Override
    public int addTeacher(EduTeacher eduTeacher) {
        Date date = new Date();
        eduTeacher.setGmtCreated(date);
        eduTeacher.setGmtModified(date);
        eduTeacher.setIsDeleted(false);
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
            file.transferTo(new File(dateFolder, imgName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new EduException("上传图片失败");
        }

        return EduResult.ok().data("imgPath", EduConstant.HOST + "/" + UploadUtils.getDateFolder() + "/" + imgName);
    }

    @Override
    public int deleteTeacher(List<Integer> ids) {
        int count = eduTeacherMapper.deleteTeacher(ids);
        if (count <= 0) {
            throw new EduException("删除讲师失败");
        }
        return count;
    }

    @Override
    public int updateTeacher(EduTeacher eduTeacher) {
        eduTeacher.setGmtModified(new Date());
        int count = eduTeacherMapper.updateTeacher(eduTeacher);
        if (count <= 0) {
            throw new EduException("修改讲师失败");
        }
        return count;
    }

    @Override
    public EduResult conditionPageQuery(Integer currentPage, Integer limit, EduTeacher eduTeacher) {
        int totalRowsNum = eduTeacherMapper.totalRowsNum(eduTeacher);
        int index = (currentPage - 1) * limit; //得到limit的起始值
        List<EduTeacher> currentPageTeacher = eduTeacherMapper.currentPageTeacher(index, limit, eduTeacher);
        return EduResult.ok().data("total", totalRowsNum).data("rows", currentPageTeacher);
    }

    @Override
    public EduResult deleteTeacherById(int deleteId) {
        int count = eduTeacherMapper.deleteTeacherById(deleteId);
        if (count <= 0) {
            throw new EduException("删除失败请重试");
        }
        return EduResult.ok();
    }

    @Override
    public EduResult findTeacherAll() {
        List<EduTeacher> teacherList = eduTeacherMapper.findTeacherAll();
        return EduResult.ok().data("teacherList",teacherList);
    }
}
