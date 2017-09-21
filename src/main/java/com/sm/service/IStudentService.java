package com.sm.service;

import com.sm.entities.Student;

public interface IStudentService extends IBaseService<Student>{

	boolean findBystuNum(String stuNum);

	Student findByLogin(String stuName, String stuPwd);
}
