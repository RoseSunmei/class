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
		// �������ڶ���
		//Date current_date = new Date();
		Date current_date = new Date(0);
		// �������ڸ�ʽ����ʽΪ��yyyy-MM-dd
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// ��ʽ����ǰ����
		SimpleDateFormat.format(current_date.getTime());
		// �������һ��
		System.out.println("��ǰ��ϵͳ����Ϊ��"
				+ SimpleDateFormat.format(current_date.getTime()));
		for (int i = 12; i < 100; i++) {
			Student student = new Student();
			student.setStuNum("+i+");
			student.setStuName("+i+");
			if (i % 2 == 0) {
				student.setStuSex("Ů");
				student.setStuAddress("ʯ��ׯ");
				student.setClas(new Clas(2L));
			} else if (i % 3 == 0) {
				student.setStuAddress("�ɶ�");
				student.setClas(new Clas(3L));
			}else if (i % 5 == 0) {
				student.setStuAddress("����");
				student.setClas(new Clas(4L));
			} else {
				student.setStuSex("��");
				student.setStuAddress("����");
				student.setClas(new Clas(1L));
			}
			student.setStuBirth(current_date);
			student.setStuPwd("+i+");
			student.setStuPhone("+i+");
			studentService.save(student);
		}
	}

}
