package com.steven.tutorial.web.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.steven.tutorial.web.domain.Book;
import com.steven.tutorial.web.domain.Student;
import com.steven.tutorial.web.domain.TableData;

public class TableDataGsonTest {

	@Test
	public void test() {

		List<TableData<?>> lstTableData = new ArrayList<TableData<?>>();
		List<Student> lstStudent = new ArrayList<Student>();
		lstStudent.add(new Student(1, "liu", new Date()));
		lstStudent.add(new Student(2, "yang", new Date()));
		TableData<Student> stuTableData = new TableData<Student>();
		stuTableData.setTableData(lstStudent);
		stuTableData.setTableName("student");
		lstTableData.add(stuTableData);

		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "Json从入门到精通", 10.80f));
		books.add(new Book(2, "设计模式", 28.88f));
		TableData<Book> stuBookData = new TableData<Book>();
		stuBookData.setTableData(books);
		stuBookData.setTableName("book");
		lstTableData.add(stuBookData);

		System.out.println("Start to convert using gson:");
		Gson gson = new Gson();
		String strJson = gson.toJson(lstTableData);
		System.out.println(strJson);
		System.out.println("Start to generate object using gson:");
		// 重新将json串转换为对象
		Type listType = new TypeToken<List<TableData<?>>>() {
		}.getType();
		List<TableData<?>> lstResult = gson.fromJson(strJson, listType);
		for (TableData<?> item : lstResult) {
			String tableName = item.getTableName();
			List<?> tableData = item.getTableData();
			String strJsonTableData = gson.toJson(tableData);
			if (tableName.equals("student")) {
				System.out.println("students");
				List<Student> lstConventStudents = gson.fromJson(strJsonTableData, new TypeToken<List<Student>>() {
				}.getType());
				for (Student stu : lstConventStudents) {
					System.out.println(stu);
				}

			} else if (tableName.equals("book")) {
				System.out.println("books");
				List<Book> lstConventBooks = gson.fromJson(strJsonTableData, new TypeToken<List<Book>>() {
				}.getType());
				for (Book book : lstConventBooks) {
					System.out.println(book);
				}
			}

		}

	}

}
