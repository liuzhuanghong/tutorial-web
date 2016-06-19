package com.steven.tutorial.web.db.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.h2.tools.Server;
import org.junit.Test;

public class H2ConnTest {

	// 数据库连接URL，当前连接的是h2内置的test数据库
	private static final String JDBC_URL = "jdbc:h2:~/test";
	private static final String TCP_JDBC_URL = "jdbc:h2:tcp://localhost/~/test";

	// 连接数据库时使用的用户名
	private static final String USER = "sa";
	// 连接数据库时使用的密码
	private static final String PASSWORD = "";
	// 连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
	private static final String DRIVER_CLASS = "org.h2.Driver";

	// H2数据库服务器启动实例
	private static Server server;

	@Test
	public void test() {
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			System.out.println("通过本地数据库的方式查询");
			// 查询
			ResultSet rs = stmt.executeQuery("SELECT * FROM test");
			// 遍历结果集
			while (rs.next()) {
				System.out.println(rs.getString("id") + ":" + rs.getString("name"));
			}
			// 释放资源
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTCPConnect() {
		startServer();
		try {
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(TCP_JDBC_URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 查询
			ResultSet rs = stmt.executeQuery("SELECT * FROM test");
			System.out.println("通过TCP的方式查询");
			// 遍历结果集
			while (rs.next()) {
				System.out.println(rs.getString("id") + ":" + rs.getString("name"));
			}
			// 释放资源
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		stopServer();
	}

	/**
	 * 使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，
	 * 那么H2数据库启动时默认占用的端口就是8082
	 */
	private static void startServer() {
		try {
			System.out.println("正在启动h2数据库...");
			// 使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，那么H2数据库启动时默认占用的端口就是8082
			server = Server.createTcpServer().start();
			System.out.println("h2数据库启动成功...");

		} catch (Exception e) {
			System.out.println("启动h2数据库出错：" + e.toString());
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 停止H2数据库
	 */
	private static void stopServer() {
		if (server != null) {
			System.out.println("停止H2数据库");
			// 停止H2数据库
			server.stop();
			server = null;
		}
	}

}
