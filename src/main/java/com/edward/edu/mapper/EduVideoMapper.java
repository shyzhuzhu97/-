package com.edward.edu.mapper;

import com.edward.edu.bean.EduVideo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EduVideoMapper {
    int addVideo(EduVideo video);
}
