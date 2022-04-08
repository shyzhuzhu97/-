package com.edward.edu;

import com.edward.edu.bean.EduTeacher;
import com.edward.edu.controller.SubjectController;
import com.edward.edu.mapper.EduTeacherMapper;
import com.edward.edu.service.TeacherService;
import com.edward.edu.vo.EduResult;
import com.edward.edu.vo.ExcelVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EduApplicationTests {
	@Autowired
	private EduTeacherMapper teacherMapper;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectController subjectController;
	@Test
	void contextLoads() {
		int i = 1;
		EduResult eduTeacher = teacherService.findTeacherById(i);
		System.out.println(eduTeacher);
	}
	@Test
	void contextLoads2() {
		List<EduTeacher> teacherAll = teacherMapper.findTeacherAll();
		System.out.println(teacherAll);
	}
	@Test
	void downloadExcel() {
		List<ExcelVo> data = subjectController.getData();
		System.out.println(data);
	}

}
