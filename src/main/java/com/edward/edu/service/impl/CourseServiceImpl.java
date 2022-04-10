package com.edward.edu.service.impl;

import com.edward.edu.constant.EduConstant;
import com.edward.edu.exception.EduException;
import com.edward.edu.service.CourseService;
import com.edward.edu.utils.UploadUtils;
import com.edward.edu.vo.EduResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class CourseServiceImpl implements CourseService {
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
}
