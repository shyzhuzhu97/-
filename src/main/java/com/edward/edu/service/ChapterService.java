package com.edward.edu.service;

import com.edward.edu.bean.EduChapter;
import com.edward.edu.vo.EduResult;

public interface ChapterService {

    EduResult findChapterAll(Integer courseId);

    EduResult addChapter(EduChapter eduChapter);
}
