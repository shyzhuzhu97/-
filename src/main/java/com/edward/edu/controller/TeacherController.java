package com.edward.edu.controller;



import com.edward.edu.bean.EduLog;
import com.edward.edu.bean.EduTeacher;
import com.edward.edu.service.TeacherService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController //RequestBody+Controller
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/indexTeacher")
    public EduResult indexTeacher() {
        List<EduTeacher> teacherAll = teacherService.findFourTeacher();
        if(teacherAll==null){
            return EduResult.error(teacherAll);
        }
        return EduResult.ok(teacherAll);
    }

    @RequestMapping("/addTeacher")
    public EduResult addTeacher(@Valid @RequestBody EduTeacher eduTeacher) {
        int i = teacherService.addTeacher(eduTeacher);
        return EduResult.ok("count:"+i);
    }
    @PostMapping("/uploadAvatar")
    public EduResult uploadAvatar(MultipartFile file){
        EduResult result = teacherService.uploadAvatar(file);
        return result;
    }

}
