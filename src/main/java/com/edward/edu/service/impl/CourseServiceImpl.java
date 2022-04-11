package com.edward.edu.service.impl;

import com.edward.edu.bean.EduCourse;
import com.edward.edu.bean.EduCourseDes;
import com.edward.edu.constant.EduConstant;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduCourseMapper;
import com.edward.edu.service.CourseService;
import com.edward.edu.utils.UploadUtils;
import com.edward.edu.vo.CourseVo;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    EduCourseMapper eduCourseMapper;

    @Override
    public EduResult uploadImg(MultipartFile file) {
        File dateFolder = UploadUtils.getCourseImgFolderRoot();
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

        return EduResult.ok().data("imgPath", EduConstant.HOST + "/" + UploadUtils.getCourseImgFolder() + "/" + imgName);
    }

    @Override
    @Transactional
    public EduResult addCourse(CourseVo course) {
        EduCourse eduCourse = course.getEduCourse();
        EduCourseDes eduCourseDes = course.getEduCourseDes();
        //添加数据
        Date date = new Date();
        eduCourse.setGmtCreated(date);
        eduCourse.setGmtModified(date);
        eduCourse.setStatus("Draft");
        int count1 = eduCourseMapper.addCourse(eduCourse);
        if(count1<=0){
            throw new EduException("添加课程失败");
        }
        eduCourseDes.setId(eduCourse.getId());
        eduCourseDes.setGmtCreated(date);
        eduCourseDes.setGmtModified(date);

        int count2 = eduCourseMapper.addCourseDes(eduCourseDes);
        if(count2<=0){
            throw new EduException("添加课程失败");
        }
        return EduResult.ok().data("courseId",eduCourse.getId());
    }
    @Override
    @Transactional
    public EduResult updateCourse(CourseVo course) {
        EduCourse eduCourse = course.getEduCourse();
        EduCourseDes eduCourseDes = course.getEduCourseDes();
        Date date = new Date();
        eduCourse.setGmtModified(date);
        eduCourseDes.setGmtModified(date);
        int count1 = eduCourseMapper.updateCourse(eduCourse);
        if(count1<=0){
            throw new EduException("修改课程失败");
        }
        int count2 = eduCourseMapper.updateCourseDes(eduCourseDes);
        if(count2<=0){
            throw new EduException("修改课程失败");
        }
        return EduResult.ok().data("courseId",eduCourse.getId());
    }

    @Override
    @Transactional
    public EduResult getCourseById(Integer id) {
        EduCourse eduCourse =eduCourseMapper.getCourseById(id);
        EduCourseDes eduCourseDes = eduCourseMapper.getCourseDesById(id);
        if(eduCourse == null ||eduCourseDes==null){
            throw new EduException("查询课程失败，请重试");

        }
        return EduResult.ok().data("eduCourse",eduCourse).data("eduCourseDes",eduCourseDes);
    }


}
