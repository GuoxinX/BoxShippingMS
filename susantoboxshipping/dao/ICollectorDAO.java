package com.susantoboxshipping.dao;

import java.sql.SQLException;

import com.susantoboxshipping.vo.Collector;

public interface ICollectorDAO {
	/**
	 * check a collector with email and password in database
	 * @param vo with password and email
	 * @return if the collector in database return true else return false 
	 * */
	public boolean isInDatabase(Collector vo) throws SQLException;
	/**
	 * find a collector in database by email
	 * @param email
	 * @return if the email in database return collector with all in formation else return null
	 * */
	public Collector findByEmail(String email) throws SQLException;
}
