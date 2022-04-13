package com.edward.edu.service.impl;

import com.edward.edu.bean.EduChapter;
import com.edward.edu.bean.EduVideo;
import com.edward.edu.exception.EduException;
import com.edward.edu.mapper.EduChapterMapper;
import com.edward.edu.service.ChapterService;
import com.edward.edu.service.VideoService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    EduChapterMapper eduChapterMapper;
    @Autowired
    VideoService videoService;

    @Override
    public EduResult findChapterAll(Integer courseId) {
        List<EduChapter> chapterList = eduChapterMapper.findChapterAll(courseId);
        System.out.println(chapterList);
        if (chapterList == null){
            throw new EduException("查询失败");
        }
        return EduResult.ok().data("chapterList",chapterList);
    }

    @Override
    @Transactional
    public EduResult addChapter(EduChapter eduChapter) {
        //补充数据
        Date date = new Date();
        eduChapter.setGmtCreated(date);
        eduChapter.setGmtModified(date);

        int count = eduChapterMapper.addChapter(eduChapter);
        for(EduVideo video:eduChapter.getVideoList()){
            video.setChapterId(eduChapter.getId());
            video.setSort(eduChapter.getSort());
            int i = videoService.addVideo(video);
            if(i<=0){
                throw new EduException("添加失败");
            }
        }
        if(count<=0){
            throw new EduException("添加失败");
        }
        return EduResult.ok().data("count",count);
    }
}
