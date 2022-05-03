package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

//database Connection Information
public class DbConnect {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bankdb";
	private static String un = "root";
	private static String pa = "root";
	static Connection conn = null;
	
	public static  Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, un, pa);
			if(conn==null) {
				System.out.println("Error in Connection");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
