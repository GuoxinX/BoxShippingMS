package com.susantoboxshipping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.susantoboxshipping.dbc.DatabaseConnection;
import com.susantoboxshipping.vo.Shipper;

public class ShipperDAOImpl implements IShipperDAO {
	public Connection conn = new DatabaseConnection().getConnection();
	public PreparedStatement pstmt;
	@Override
	public boolean isInDatabase(Shipper vo) throws SQLException {
		boolean flag = false ;
		String sql = "SELECT email FROM shipper WHERE email=? AND password=?" ;
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
	public Shipper findByEmail(String email) throws SQLException {
		Shipper vo = null;
		String sql = "SELECT email,password,name FROM shipper WHERE email=?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Shipper();
			vo.setEmail(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
		}
		return vo;
	}

}
