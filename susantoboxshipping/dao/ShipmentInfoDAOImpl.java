package com.susantoboxshipping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.susantoboxshipping.vo.ShipmentInfo;

import com.susantoboxshipping.dbc.DatabaseConnection;

public class ShipmentInfoDAOImpl implements IShipmentInfoDAO {
	public Connection conn = new DatabaseConnection().getConnection();
	public PreparedStatement pstmt;
	@Override
	public ArrayList<ShipmentInfo> getAll() throws SQLException {
		ArrayList<ShipmentInfo> result = new ArrayList<ShipmentInfo>();
		String sql = "SELECT id,depature_data,arrival_data FROM shipment_information" ;
		pstmt = conn.prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ShipmentInfo vo = new ShipmentInfo();
			vo.setId(rs.getInt(1));
			vo.setDepartureDate(rs.getTimestamp(2));
			vo.setArrivalDate(rs.getTimestamp(3));
			result.add(vo);
		}
		return result;
	}

}
