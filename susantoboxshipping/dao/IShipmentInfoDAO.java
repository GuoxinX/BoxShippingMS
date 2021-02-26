package com.susantoboxshipping.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.susantoboxshipping.vo.ShipmentInfo;

public interface IShipmentInfoDAO {
	/**
	 * get all shipment info
	 * @return all shipment info
	 * */
	public ArrayList<ShipmentInfo> getAll() throws SQLException;
}
