package com.edward.edu.mapper;

import com.edward.edu.bean.EduChapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduChapterMapper {
    int addChapter(EduChapter eduChapter);

    List<EduChapter> findChapterAll(Integer courseId);
}
