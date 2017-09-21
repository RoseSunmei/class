package com.sm.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sm.entities.Clas;
import com.sm.entities.Student;
import com.sm.service.IClasService;
import com.sm.service.IStudentService;

public class StudentServiceTest extends BaseServiceTest {
	@Autowired
	IStudentService studentService;
	IClasService clasService;

	@Test
	public void testSave() {
		// 生成日期对象
		//Date current_date = new Date();
		Date current_date = new Date(0);
		// 设置日期格式化样式为：yyyy-MM-dd
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 格式化当前日期
		SimpleDateFormat.format(current_date.getTime());
		// 输出测试一下
		System.out.println("当前的系统日期为："
				+ SimpleDateFormat.format(current_date.getTime()));
		for (int i = 12; i < 100; i++) {
			Student student = new Student();
			student.setStuNum("+i+");
			student.setStuName("+i+");
			if (i % 2 == 0) {
				student.setStuSex("女");
				student.setStuAddress("石家庄");
				student.setClas(new Clas(2L));
			} else if (i % 3 == 0) {
				student.setStuAddress("成都");
				student.setClas(new Clas(3L));
			}else if (i % 5 == 0) {
				student.setStuAddress("海南");
				student.setClas(new Clas(4L));
			} else {
				student.setStuSex("男");
				student.setStuAddress("北京");
				student.setClas(new Clas(1L));
			}
			student.setStuBirth(current_date);
			student.setStuPwd("+i+");
			student.setStuPhone("+i+");
			studentService.save(student);
		}
	}

}
