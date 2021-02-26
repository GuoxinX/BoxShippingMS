package com.susantoboxshipping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.susantoboxshipping.dbc.DatabaseConnection;
import com.susantoboxshipping.vo.Customer;



public class CustomerDAOImpl implements ICustomerDAO {
	public Connection conn = new DatabaseConnection().getConnection();
	public PreparedStatement pstmt;
	@Override
	public boolean insert(Customer vo) throws SQLException {
		String sql = "INSERT INTO customer(email,password,name,address,phone) VALUES (?,?,?,?,?)" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, vo.getEmail());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getAddress());
		pstmt.setString(5, vo.getPhone());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean isInDatabase(Customer vo) throws SQLException {
		boolean flag = false ;
		String sql = "SELECT email FROM customer WHERE email=? AND password=?" ;
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
	public Customer findByEmail(String email) throws SQLException {
		Customer vo = null;
		String sql = "SELECT email,password,name,address,phone FROM customer WHERE email=?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Customer();
			vo.setEmail(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setPhone(rs.getString(5));
		}
		return vo;
	}

	@Override
	public boolean update(Customer vo) throws SQLException {
		String sql = "UPDATE customer SET password=?,name=?,address=?,phone=? WHERE email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPassword());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getAddress());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getEmail());
		return pstmt.executeUpdate() > 0 ;
	}



}
