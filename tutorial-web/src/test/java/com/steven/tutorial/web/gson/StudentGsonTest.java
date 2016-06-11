package com.steven.tutorial.web.gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.steven.tutorial.web.domain.Student;

public class StudentGsonTest {

	@Test
	public void test() {
		
		
		Gson gson = new Gson(); 
		Student student = new Student();
		student.setName("liu");
		student.setId(1);
		student.setBirthDay(new Date());
		System.out.println("Start to convert using gson:");
		// 将简单对象转换为json串
		String strJson = gson.toJson(student);
		System.out.println(strJson);
		
		// 将json串还原为简单对象
		System.out.println("Start to generate class using gson:");
		Student student2 = gson.fromJson(strJson, Student.class);
		System.out.println(student2);
		
		System.out.println("Start to convert List object using gson:");
		student2.setId(2);
		student2.setName("yang");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		list.add(student2);
		// 将List对象转换为json串
		strJson = gson.toJson(list);
		System.out.println(strJson);
		
		System.out.println("Start to generate list using gson:");
		List<Student> listFromJson = new ArrayList<Student>();
		// 将json串还原为List对象
		listFromJson = gson.fromJson(strJson, new TypeToken<List<Student>>(){}.getType());
		for(Student stu : listFromJson){
			System.out.println(stu);
		}
		

	}

}
