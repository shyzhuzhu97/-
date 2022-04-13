package com.edward.edu.service.impl;

import com.edward.edu.bean.EduVideo;
import com.edward.edu.constant.EduConstant;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduVideoMapper;
import com.edward.edu.service.VideoService;
import com.edward.edu.utils.UploadUtils;
import com.edward.edu.vo.EduResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    EduVideoMapper eduVideoMapper;

    @Override
    public EduResult uploadVideo(MultipartFile file) {
        File dateFolder = UploadUtils.getVideoFolderRoot();
        if (!dateFolder.exists()) { //判断文件夹是否存在，如果不存在就创建这个文件夹
            dateFolder.mkdir();
        }
        //代码到这里一定有文件夹了
        String videoName = UploadUtils.getImgName(file.getOriginalFilename()); //得到新的视频名字
        //得到文件名称
        try {
            file.transferTo(new File(dateFolder, videoName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new EduException("上传视频失败");
        }

//        //补充数据库所需数据
//        EduVideo eduVideo = new EduVideo();
//        //title 生成的uuid随机名
//        eduVideo.setTitle(videoName.substring(0,videoName.lastIndexOf(".")));
//        //源文件名
//        eduVideo.setVideoOriginalName(file.getOriginalFilename());
//        //url地址
//        eduVideo.setVideoSourceId(EduConstant.HOST + "/" + UploadUtils.getVideoFolder() + "/" + videoName);

        return EduResult.ok()
                .data("videoSourceId", EduConstant.HOST + "/" + UploadUtils.getVideoFolder() + "/" + videoName)
                .data("videoOriginalName",file.getOriginalFilename())
                .data("title",videoName.substring(0,videoName.lastIndexOf(".")));
    }


    @Override
    public int addVideo(EduVideo video) {


        //补充数据
        Date date = new Date();
        File file = new File("D:\\pic", video.getVideoSourceId().substring(video.getVideoSourceId().lastIndexOf("http://localhost/") + "http://localhost/".length()));
        MultimediaObject object = new MultimediaObject(file);
        try {
            MultimediaInfo info = object.getInfo();
            //视频时长
            video.setDuration(info.getDuration() / 1000);

            video.setStatus("Normal");
            video.setVersion(1L);
            video.setGmtCreated(date);
            video.setGmtModified(date);
            System.out.println(video);
            int i = eduVideoMapper.addVideo(video);
            if (i == 0) {
                throw new EduException("添加小节视频失败");
            }
            return i;
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        return 0;

    }


}
