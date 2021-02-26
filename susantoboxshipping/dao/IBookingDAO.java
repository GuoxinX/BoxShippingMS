package com.susantoboxshipping.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.susantoboxshipping.vo.ShipmentBooking;

public interface IBookingDAO {
	/**
	 * insert a new booking into database
	 * @param vo with shipmentBooking info
	 * @return if insert successfully return true else return false
	 * */
	public boolean insert(ShipmentBooking vo) throws SQLException;
	/**
	 * update a booking status 
	 * @param vo with new status
	 * @return if update successfully return true else return false
	 * */
	public boolean updateBooking(ShipmentBooking vo) throws SQLException;
	/**
	 * get all shipmentBookings
	 * @return a list of shipmentBooking
	 * */
	public ArrayList<ShipmentBooking> getAll() throws SQLException;
	/**
	 * get a customer's all shipmentBooking
	 * @return a list of shipmentBooking
	 * */
	public ArrayList<ShipmentBooking> getByCusEmail(String email) throws SQLException;
}
