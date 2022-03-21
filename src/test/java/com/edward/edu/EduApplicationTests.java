package com.edward.edu;

import com.edward.edu.bean.EduTeacher;
import com.edward.edu.mapper.EduTeacherMapper;
import com.edward.edu.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EduApplicationTests {
	@Autowired
	private EduTeacherMapper teacherMapper;
	@Test
	void contextLoads() {
		int i = 1;
		EduTeacher eduTeacher = teacherMapper.findTeacherById(i);
		System.out.println(eduTeacher);
	}
	@Test
	void contextLoads2() {
		List<EduTeacher> teacherAll = teacherMapper.findTeacherAll();
		System.out.println(teacherAll);
	}

}
