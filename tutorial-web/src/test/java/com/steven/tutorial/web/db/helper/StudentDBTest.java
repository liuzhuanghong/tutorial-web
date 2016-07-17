package com.steven.tutorial.web.db.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.steven.tutorial.web.domain.Student;
import com.steven.tutorial.web.helper.DatabaseHelper;

public class StudentDBTest {
	
	@Before
	public void init() throws Exception{
		DatabaseHelper.executeSqlFile("db_sql/student_init.sql");
	}
	
	@Test
	public void testGetStudentList() {
		String sql =  "SELECT * FROM student";
		List<Student> students = DatabaseHelper.queryEntityList(Student.class, sql);
		for(Student item : students){
			System.out.println(item);
		}
	}
	
	@Test 
	public void testInsertStudent(){
		Map<String, Object> studentMap = new HashMap<String, Object>();
		studentMap.put("name", "gan");
		studentMap.put("birthday", "2011-01-03");
		DatabaseHelper.insertEntity(Student.class, studentMap);
	}

}
