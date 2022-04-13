package com.edward.edu.service;



import com.edward.edu.bean.EduVideo;
import com.edward.edu.vo.EduResult;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    EduResult uploadVideo(MultipartFile file);

    int addVideo(EduVideo video);
}
