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
import com.susantoboxshipping.vo.ShipmentInfo;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetShippmentInfo
 */
@WebServlet("/getShippmentInfo")
public class GetShippmentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShippmentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShipmentInfo> result = new ArrayList<ShipmentInfo>(); 
		int code;
		try {
			result = DAOFactory.getIShipmentInfoDAOInstance().getAll();
			code = 0;
		} catch (SQLException e) {
			code = -2;
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		for(int i=0;i<result.size();i++) {
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("id", result.get(i).getId());
			jsonObject1.put("departureDate", result.get(i).getDepartureDate().getTime());
			jsonObject1.put("arrivalDate", result.get(i).getArrivalDate().getTime());
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
