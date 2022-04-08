package com.edward.edu.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

@ContentRowHeight(20) //内容的行高
@HeadRowHeight(30) //表头的行高
public class ExcelVo {

    @ExcelProperty(value = "一级课程分类名称")
    private String subjectOneName;

    @ExcelProperty(value = "二级课程分类名称")
    private String subjectTwoName;

    public String getSubjectOneName() {
        return subjectOneName;
    }

    public void setSubjectOneName(String subjectOneName) {
        this.subjectOneName = subjectOneName;
    }

    public String getSubjectTwoName() {
        return subjectTwoName;
    }

    public void setSubjectTwoName(String subjectTwoName) {
        this.subjectTwoName = subjectTwoName;
    }

    @Override
    public String toString() {
        return "ExcelVo{" +
                "subjectOneName='" + subjectOneName + '\'' +
                ", subjectTwoName='" + subjectTwoName + '\'' +
                '}';
    }
}
