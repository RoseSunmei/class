package com.sm.service;

import javax.mail.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.sm.entities.Course;

public class CourseServiceTest extends BaseServiceTest{
	@Autowired
	ICourseService courseService;
	IScoreService scoreService;
	
	@Test
	public void test() {
		
	}
}
