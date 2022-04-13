package com.edward.edu.controller;

import com.edward.edu.service.VideoService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class VideoController {


    @Autowired
    VideoService videoService;


    @RequestMapping("/uploadVideo")
    public EduResult addVideo(MultipartFile file) {
        EduResult result = videoService.uploadVideo(file);
        return result;
    }

}
