package com.susantoboxshipping.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.susantoboxshipping.factory.DAOFactory;
import com.susantoboxshipping.vo.ShipmentBooking;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddBooking
 */
@WebServlet("/addBooking")
public class AddBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numOfBox = request.getParameter("numOfBox");
		String destinationAddress = request.getParameter("destinationAddress");
		String pickupAddress = request.getParameter("pickupAddress");
		String shipmentInfoId = request.getParameter("shipmentInfoId");
		String messageCustomer = request.getParameter("messageCustomer");
		String customerEmail = request.getParameter("customerEmail");
		ShipmentBooking vo = new ShipmentBooking();
		vo.setNumOfBox(Integer.parseInt(numOfBox));
		vo.setDesAddress(destinationAddress);
		vo.setPicAdress(pickupAddress);
		vo.setShipmentInfoId(Integer.parseInt(shipmentInfoId));
		vo.setMessageCus(messageCustomer);
		vo.setCusEmail(customerEmail);
		vo.setStatus(0); //0:To be Approved 1:Request Accepted 2:Pick-up Scheduled 3:to be Shipped 4:Shipped  5:Arrived at Destination 6:Delivered  7:Delivery Delayed.
		int code;
		String info;
		try {
			if(DAOFactory.getIBookingDAOInstance().insert(vo)) {
				code = 0;
				info = "insert new booking success!";
			}else {
				code = -1;
				info = "insert new booking fail!";
			}
		} catch (SQLException e) {
			code = -2;
			info = "MySQL error!";
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("info", info);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
		response.getWriter().append(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
