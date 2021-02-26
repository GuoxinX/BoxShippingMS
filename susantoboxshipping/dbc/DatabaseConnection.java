package com.susantoboxshipping.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/susantoboxshipping";
    private static final String DBUSER="root";
    private static final String DBPASSWORD="961029";
	private Connection conn;
	
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			System.out.println("***************database connect success!************");
		} catch (Exception e) {
			System.out.println("***************database connect failed!************");
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return this.conn ;
	}
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
