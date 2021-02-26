package com.susantoboxshipping.dao;

import java.sql.SQLException;

import com.susantoboxshipping.vo.Shipper;


public interface IShipperDAO {
	/**
	 * check a shipper with email and password in database
	 * @param vo with password and email
	 * @return if the shipper in database return true else return false 
	 * */
	public boolean isInDatabase(Shipper vo) throws SQLException;
	/**
	 * find a shipper in database by email
	 * @param email
	 * @return if the email in database return customer with all in formation else return null
	 * */
	public Shipper findByEmail(String email) throws SQLException;
}
