package com.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
		
	//properties file or xml file --read data from here
	

	private String dburl = "jdbc:mysql://localhost:3306/grey_goose";
	private String dbuname = "root";
	private String dbpassword = "root";
	private String dbdriver = "com.mysql.jdbc.Driver";
	
	
	public void loadDriver () {
		try {
			getClass().forName(dbdriver);//load driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl ,dbuname ,dbpassword);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
