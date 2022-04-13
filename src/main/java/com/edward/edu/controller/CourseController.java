package com.edward.edu.controller;


import com.edward.edu.bean.EduCourse;
import com.edward.edu.bean.EduCourseDes;
import com.edward.edu.service.CourseService;
import com.edward.edu.vo.CourseVo;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/uploadImg")
    public EduResult uploadImg(MultipartFile file) {
        EduResult result = courseService.uploadImg(file);
        return result;
    }

    @PostMapping("/addCourse")
    public EduResult addCourse(@RequestBody CourseVo course) {
        EduResult result = courseService.addCourse(course);

        return result;
    }
    @PostMapping("/updateCourse")
    public EduResult updateCourse(@RequestBody CourseVo course) {
        EduResult result = courseService.updateCourse(course);

        return result;
    }
    @RequestMapping("/getCourseById/{id}")
    public EduResult getCourseById(@PathVariable Integer id) {
        EduResult result = courseService.getCourseById(id);

        return result;
    }







}
