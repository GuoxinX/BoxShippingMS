package com.susantoboxshipping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.susantoboxshipping.vo.ShipmentBooking;

import com.susantoboxshipping.dbc.DatabaseConnection;

public class BookingDAOImpl implements IBookingDAO {
	public Connection conn = new DatabaseConnection().getConnection();
	public PreparedStatement pstmt;
	@Override
	public boolean insert(ShipmentBooking vo) throws SQLException {
		String sql = "INSERT INTO shipping_booking(num0fbox,destination_address,pickup_address,shipment_information_id,message_customer,status,pickup_time,message_shipper,customer_email,shipper_email,collector_email) VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setInt(1, vo.getNumOfBox());
		pstmt.setString(2, vo.getDesAddress());
		pstmt.setString(3, vo.getPicAdress());
		pstmt.setInt(4, vo.getShipmentInfoId());
		pstmt.setString(5, vo.getMessageCus());
		pstmt.setInt(6, vo.getStatus());
		pstmt.setString(7, vo.getPicTime());
		pstmt.setString(8, vo.getMessageShi());
		pstmt.setString(9, vo.getCusEmail());
		pstmt.setString(10, vo.getShiEmail());
		pstmt.setString(11, vo.getColEmail());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean updateBooking(ShipmentBooking vo) throws SQLException {
		String sql = "UPDATE shipping_booking SET status=?,pickup_time=?,shipper_email=?,collector_email=?,message_shipper=? WHERE id=?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setInt(1, vo.getStatus());
		pstmt.setString(2, vo.getPicTime());
		pstmt.setString(3, vo.getShiEmail()); //cost
		pstmt.setString(4, vo.getColEmail()); //HBL number
		pstmt.setString(5, vo.getMessageShi());
		pstmt.setInt(6, vo.getId());
		return pstmt.executeUpdate() > 0 ;
	}

	@Override
	public ArrayList<ShipmentBooking> getAll() throws SQLException {
		ArrayList<ShipmentBooking> result = new ArrayList<ShipmentBooking>();
		String sql = "SELECT id,num0fbox,destination_address,pickup_address,shipment_information_id,message_customer,status,pickup_time,message_shipper,customer_email,shipper_email,collector_email FROM shipping_booking";
		pstmt = conn.prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ShipmentBooking vo = new ShipmentBooking();
			vo.setId(rs.getInt(1));
			vo.setNumOfBox(rs.getInt(2));
			vo.setDesAddress(rs.getString(3));
			vo.setPicAdress(rs.getString(4));
			vo.setShipmentInfoId(rs.getInt(5));
			vo.setMessageCus(rs.getString(6));
			vo.setStatus(rs.getInt(7));
			vo.setPicTime(rs.getString(8));
			vo.setMessageShi(rs.getString(9));
			vo.setCusEmail(rs.getString(10));
			vo.setShiEmail(rs.getString(11));
			vo.setColEmail(rs.getString(12));
			result.add(vo);
		}
		return result;
	}

	@Override
	public ArrayList<ShipmentBooking> getByCusEmail(String email) throws SQLException {
		ArrayList<ShipmentBooking> result = new ArrayList<ShipmentBooking>();
		String sql = "SELECT id,num0fbox,destination_address,pickup_address,shipment_information_id,message_customer,status,pickup_time,message_shipper,customer_email,shipper_email,collector_email FROM shipping_booking WHERE customer_email=?";
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ShipmentBooking vo = new ShipmentBooking();
			vo.setId(rs.getInt(1));
			vo.setNumOfBox(rs.getInt(2));
			vo.setDesAddress(rs.getString(3));
			vo.setPicAdress(rs.getString(4));
			vo.setShipmentInfoId(rs.getInt(5));
			vo.setMessageCus(rs.getString(6));
			vo.setStatus(rs.getInt(7));
			vo.setPicTime(rs.getString(8));
			vo.setMessageShi(rs.getString(9));
			vo.setCusEmail(rs.getString(10));
			vo.setShiEmail(rs.getString(11));
			vo.setColEmail(rs.getString(12));
			result.add(vo);
		}
		return result;
	}

}
