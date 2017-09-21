package com.sm.service;

import com.sm.entities.Course;

public interface ICourseService extends IBaseService<Course> {

	boolean findBycouNum(String couNum);

	boolean findBycouName(String couName);
	
}
