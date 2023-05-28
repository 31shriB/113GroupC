package com.quizproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/quizdb?characterEncoding=utf8";
			con=DriverManager.getConnection(url, "root", "root123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		return con;	
	}
}
