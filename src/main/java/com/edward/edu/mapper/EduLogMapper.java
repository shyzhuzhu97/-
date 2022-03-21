package com.edward.edu.mapper;

import com.edward.edu.bean.EduLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EduLogMapper {
    int addLog(EduLog eduLog);
}
