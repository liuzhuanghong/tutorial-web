package com.steven.tutorial.web.activiti;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.steven.tutorial.web.util.PropsUtil;

public class PropsUtilTest {

	private static String FILE_PATH = "props_test.properties";
	
	@Test
	public void test() {
		Properties conf = PropsUtil.loadProps(FILE_PATH);
		int age = PropsUtil.getInt(conf, "age");
		String name = PropsUtil.getString(conf, "name");
		boolean result = PropsUtil.getBoolean(conf, "result");
		Assert.assertEquals(age, 18);
		Assert.assertEquals(name, "liu");
		Assert.assertTrue(result);
	}

}
