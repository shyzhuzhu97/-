package com.edward.edu.controller;

import com.edward.edu.bean.EduChapter;
import com.edward.edu.service.ChapterService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @RequestMapping("/findChapterAll/{courseId}")
    public EduResult findChapterAll(@PathVariable Integer courseId) {
        EduResult result = chapterService.findChapterAll(courseId);
        return result;
    }

    @RequestMapping("/addChapter")
    public EduResult addChapter(@RequestBody EduChapter chapter) {
        EduResult result = chapterService.addChapter(chapter);
        return result;
    }


}
