package com.susantoboxshipping.factory;

import com.susantoboxshipping.dao.BookingDAOImpl;
import com.susantoboxshipping.dao.CollectorDAOImpl;
import com.susantoboxshipping.dao.CustomerDAOImpl;
import com.susantoboxshipping.dao.IBookingDAO;
import com.susantoboxshipping.dao.ICollectorDAO;
import com.susantoboxshipping.dao.ICustomerDAO;
import com.susantoboxshipping.dao.IShipmentInfoDAO;
import com.susantoboxshipping.dao.IShipperDAO;
import com.susantoboxshipping.dao.ShipmentInfoDAOImpl;
import com.susantoboxshipping.dao.ShipperDAOImpl;

public class DAOFactory {
	public static ICustomerDAO getICustomerDAOInstance() {
		return new CustomerDAOImpl();
	}
	public static IShipperDAO getIShipperDAOInstance() {
		return new ShipperDAOImpl();
	}
	public static ICollectorDAO getICollectorDAOInstance() {
		return new CollectorDAOImpl();
	}
	public static IShipmentInfoDAO getIShipmentInfoDAOInstance() {
		return new ShipmentInfoDAOImpl();
	}
	public static IBookingDAO getIBookingDAOInstance() {
		return new BookingDAOImpl();
	}
}
