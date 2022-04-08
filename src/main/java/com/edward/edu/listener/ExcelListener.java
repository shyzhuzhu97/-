package com.edward.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.edward.edu.bean.EduSubject;
import com.edward.edu.mapper.EduSubjectMapper;
import com.edward.edu.vo.ExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ExcelListener extends AnalysisEventListener<ExcelVo> {

    @Autowired
    private EduSubjectMapper eduSubjectMapper;


    @Override
    public void invoke(ExcelVo excelVo, AnalysisContext analysisContext) {
        Date date = new Date();
        EduSubject subjectOne = eduSubjectMapper.findSubjectByName(excelVo.getSubjectOneName());
        if (subjectOne == null) { //判断一级课程是否存在 为null则不存在，开始添加一级课程
            subjectOne = new EduSubject();
            subjectOne.setTitle(excelVo.getSubjectOneName());
            subjectOne.setParentId(0);
            subjectOne.setSort(0);
            subjectOne.setIsDeleted(0);
            subjectOne.setGmtCreated(date);
            subjectOne.setGmtModified(date);
            eduSubjectMapper.addSubject(subjectOne);
        }
        //到这里一级课程一定存在 且存在id 添加二级课程
        EduSubject subjectTwo = eduSubjectMapper.findSubjectByName(excelVo.getSubjectTwoName());
        if(subjectTwo==null) {
            subjectTwo = new EduSubject();
            subjectTwo.setTitle(excelVo.getSubjectTwoName());
            subjectTwo.setParentId(subjectOne.getId());
            subjectTwo.setSort(0);
            subjectTwo.setIsDeleted(0);
            subjectTwo.setGmtCreated(date);
            subjectTwo.setGmtModified(date);
            eduSubjectMapper.addSubject(subjectTwo);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
