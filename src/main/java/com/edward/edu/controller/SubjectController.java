package com.edward.edu.controller;

import com.alibaba.excel.EasyExcel;
import com.edward.edu.bean.EduSubject;
import com.edward.edu.exception.EduException;
import com.edward.edu.listener.ExcelListener;
import com.edward.edu.mapper.EduSubjectMapper;
import com.edward.edu.vo.EduResult;
import com.edward.edu.vo.ExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private ExcelListener excelListener;

    @Autowired
    private EduSubjectMapper eduSubjectMapper;


    @RequestMapping("/uploadExcel")
    public EduResult uploadExcel(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),
                    ExcelVo.class, excelListener).sheet().doRead();
        } catch (IOException e) {
            throw new EduException("导入课程失败");
        }
        return EduResult.ok();
    }

    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletResponse response) {
        try {
            //设置响应头为 表示我们向浏览器输出的是一个excel文件
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = URLEncoder.encode
                    ("课程分类信息", "UTF-8").
                    replaceAll("\\+", "%20");
            //真正的下载文件设置
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(),
                    ExcelVo.class).sheet("模板")
                    .doWrite(getData());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ExcelVo> getData() {
        List<EduSubject> subjects = eduSubjectMapper.findSubjectAll();
        List<ExcelVo> list = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            ExcelVo excelVo = new ExcelVo();
            if(subjects.get(i).getParentId()!=0){ //直接找二级课程
                //二级课程通过parentId找到一级课程
                EduSubject subject = eduSubjectMapper.getTitleById(subjects.get(i).getParentId());
                excelVo.setSubjectOneName(subject.getTitle());
                excelVo.setSubjectTwoName(subjects.get(i).getTitle());
                list.add(excelVo);
            }
        }

        return list;
    }
}
