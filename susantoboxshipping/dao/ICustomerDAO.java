package com.susantoboxshipping.dao;

import java.sql.SQLException;

import com.susantoboxshipping.vo.Customer;

public interface ICustomerDAO {
	/**
	 * insert a customer information into database
	 * @param vo with email password name address phone
	 * @return if insert successfully return true else return false
	 * */
	public boolean insert(Customer vo) throws SQLException;
	
	/**
	 * check a customer with email and password in database
	 * @param vo with password and email
	 * @return if the customer in database return true else return false 
	 * */
	public boolean isInDatabase(Customer vo) throws SQLException;
	/**
	 * find a customer in database by email
	 * @param email
	 * @return if the email in database return customer with all in formation else return null
	 * */
	public Customer findByEmail(String email) throws SQLException;
	
	/**
	 * update a customer information
	 * @param vo with new customer information
	 * @return if update successfully return true else return false
	 * */
	public boolean update(Customer vo) throws SQLException;
}
