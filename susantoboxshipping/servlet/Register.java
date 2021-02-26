package com.susantoboxshipping.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.susantoboxshipping.factory.DAOFactory;
import com.susantoboxshipping.vo.Customer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Customer vo = new Customer();
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setName(name);
		vo.setAddress(address);
		vo.setPhone(phone);
		System.out.println(vo);
		try {
			if(DAOFactory.getICustomerDAOInstance().findByEmail(email)==null && DAOFactory.getICustomerDAOInstance().insert(vo)) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", 0);
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("info", "register in successfully!");
				jsonObject.put("data", jsonObject1);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    request.setCharacterEncoding("UTF-8");
				response.getWriter().append(jsonObject.toString());
			}else {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", -1);
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("info", "email exist!");
				jsonObject.put("data", jsonObject1);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    request.setCharacterEncoding("UTF-8");
				response.getWriter().append(jsonObject.toString());
			}
		} catch (SQLException e) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", -2);
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("info", "MySQL error!");
			jsonObject.put("data", jsonObject1);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    request.setCharacterEncoding("UTF-8");
			response.getWriter().append(jsonObject.toString());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
