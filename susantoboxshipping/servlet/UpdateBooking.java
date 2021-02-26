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
 * Servlet implementation class UpdateBooking
 */
@WebServlet("/updateBooking")
public class UpdateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code;
		String info;
		String id = request.getParameter("bookingId");
		String status = request.getParameter("status");
		String picTime = request.getParameter("pickupTime");
		String cost = request.getParameter("cost");
		String HBL = request.getParameter("HBL");
		String messageShipper = request.getParameter("messageShipper");
		ShipmentBooking vo = new ShipmentBooking();
		vo.setId(Integer.parseInt(id));
		vo.setStatus(Integer.parseInt(status));
		vo.setPicTime(picTime);
		vo.setShiEmail(cost);
		vo.setColEmail(HBL);
		vo.setMessageShi(messageShipper);
		try {
			if(DAOFactory.getIBookingDAOInstance().updateBooking(vo)) {
				code  = 0;
				info = "success";
			}else {
				code  = -1;
				info = "fail";
			}
		} catch (SQLException e) {
			code  = -2;
			info = "MySQL error";
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
