package com.steven.tutorial.web.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.steven.tutorial.web.domain.Book;

public class BookGsonBuilderTest {

	@Test
	public void test() {

		// 注意这里的Gson的构建方式为GsonBuilder,区别于test1中的Gson gson = new Gson();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() // 不导出实体中没有用@Expose注解的属性
				.enableComplexMapKeySerialization() // 支持Map的key为复杂对象的形式
				.serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")// 时间转化为特定格式
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)// 会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
				.setPrettyPrinting() // 对json结果格式化.
				.setVersion(1.0) // 有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
									// @Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
									// @Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
				.create();
		
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "Json从入门到精通", 10.80f));
		books.add(new Book(2, "设计模式", 28.88f));
		// 将对象转换为json字符串
		String strBooksJson = gson.toJson(books);
		System.out.println("Convert to json:");
		System.out.println(strBooksJson);
		
		// 将json字符串转换为List对象
		List<Book> newBooks = new ArrayList<Book>();
		Type bookListType = new TypeToken<List<Book>>(){}.getType();
		System.out.println("Convert from json:");
		newBooks = gson.fromJson(strBooksJson, bookListType);
		for(Book book : newBooks){
			// 因为price没有被json化，所以还原后的price均为0
			System.out.println(book);
		}
		
	}

}
