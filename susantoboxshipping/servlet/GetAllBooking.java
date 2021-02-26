package com.susantoboxshipping.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.susantoboxshipping.factory.DAOFactory;
import com.susantoboxshipping.vo.ShipmentBooking;

import net.sf.json.JSONObject;;

/**
 * Servlet implementation class GetAllBooking
 */
@WebServlet(name = "getAllBooking", urlPatterns = { "/getAllBooking" })
public class GetAllBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShipmentBooking> result = new ArrayList<ShipmentBooking>();
		int code;
		try {
			result = DAOFactory.getIBookingDAOInstance().getAll();
			code = 0;
		} catch (SQLException e) {
			code = -2;
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++) {
			ShipmentBooking vo = result.get(i);
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("id", vo.getId());
			jsonObject1.put("numOfBox", vo.getNumOfBox());
			jsonObject1.put("destinationAddress", vo.getDesAddress());
			jsonObject1.put("pickupAddress", vo.getPicAdress());
			jsonObject1.put("shipmentInfoId", vo.getShipmentInfoId());
			jsonObject1.put("messageCustomer", vo.getMessageCus());
			jsonObject1.put("customerEmail", vo.getCusEmail());
			jsonObject1.put("status", vo.getStatus());
			jsonObject1.put("pickupTime", vo.getPicTime());
			jsonObject1.put("cost", vo.getShiEmail());
			jsonObject1.put("HBL", vo.getColEmail());
			jsonObject1.put("messageShipper", vo.getMessageShi());
			jsonObjects.add(jsonObject1);
		}
		jsonObject.put("data", jsonObjects);
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
