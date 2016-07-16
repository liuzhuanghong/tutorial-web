package com.steven.tutorial.web.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlTest {
	
	
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/liu";
    private static final String UNAME = "root";
    private static final String PWD = "pntdcg7";

    private static Connection conn = null;

    static
    {
        try
        {
            // 1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, UNAME, PWD);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


	@Test
	public void test() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,age from student");
		try {
			PreparedStatement ptmt = conn.prepareStatement(sb.toString());
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
				System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name"));
			}
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
