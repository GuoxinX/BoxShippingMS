package com.susantoboxshipping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.susantoboxshipping.dbc.DatabaseConnection;
import com.susantoboxshipping.vo.Collector;

public class CollectorDAOImpl implements ICollectorDAO {
	public Connection conn = new DatabaseConnection().getConnection();
	public PreparedStatement pstmt;
	@Override
	public boolean isInDatabase(Collector vo) throws SQLException {
		boolean flag = false ;
		String sql = "SELECT email FROM collector WHERE email=? AND password=?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, vo.getEmail());
		pstmt.setString(2, vo.getPassword());
		ResultSet rs = pstmt.executeQuery() ;
        if (rs.next()) {
            flag = true ;
        }
		return flag;
	}

	@Override
	public Collector findByEmail(String email) throws SQLException {
		Collector vo = null;
		String sql = "SELECT email,password,name FROM collector WHERE email=?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Collector();
			vo.setEmail(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
		}
		return vo;
	}

}
