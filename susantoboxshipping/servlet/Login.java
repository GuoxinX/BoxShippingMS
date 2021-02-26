package com.susantoboxshipping.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.susantoboxshipping.factory.DAOFactory;
import com.susantoboxshipping.vo.Collector;
import com.susantoboxshipping.vo.Customer;
import com.susantoboxshipping.vo.Shipper;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//role="shipper" "collector" "customer"
		String role = request.getParameter("role");
		if(role.equals("customer")) {
			try {
				Customer vo = new Customer();
				vo.setEmail(email);
				vo.setPassword(password);
				if(DAOFactory.getICustomerDAOInstance().isInDatabase(vo)) {
					vo = DAOFactory.getICustomerDAOInstance().findByEmail(email);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", 0);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("email", vo.getEmail());
					jsonObject1.put("password", vo.getPassword());
					jsonObject1.put("name", vo.getName());
					jsonObject1.put("address", vo.getAddress());
					jsonObject1.put("phone", vo.getPhone());
					jsonObject1.put("state", vo.getState());
					jsonObject.put("data", jsonObject1);
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    request.setCharacterEncoding("UTF-8");
					response.getWriter().append(jsonObject.toString());
					request.getSession().setAttribute("userInfo", jsonObject.toString());
				}else {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", -1);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("info", "email or password error!");
					jsonObject.put("data", jsonObject1);
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    request.setCharacterEncoding("UTF-8");
					response.getWriter().append(jsonObject.toString());
				}
			} catch (SQLException e) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", -1);
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("info", "MySQL error!");
				jsonObject.put("data", jsonObject1);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    request.setCharacterEncoding("UTF-8");
				response.getWriter().append(jsonObject.toString());
				e.printStackTrace();
			}
		}else if(role.equals("shipper")) {
			try {
				Shipper vo = new Shipper();
				vo.setEmail(email);
				vo.setPassword(password);
				if(DAOFactory.getIShipperDAOInstance().isInDatabase(vo)) {
					vo = DAOFactory.getIShipperDAOInstance().findByEmail(email);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", 0);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("email", vo.getEmail());
					jsonObject1.put("password", vo.getPassword());
					jsonObject1.put("name", vo.getName());
					jsonObject.put("data", jsonObject1);
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    request.setCharacterEncoding("UTF-8");
					response.getWriter().append(jsonObject.toString());
					request.getSession().setAttribute("userInfo", jsonObject.toString());
				}else {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", -1);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("info", "email or password error!");
					jsonObject.put("data", jsonObject1);
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    request.setCharacterEncoding("UTF-8");
					response.getWriter().append(jsonObject.toString());
				}
			} catch (SQLException e) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("code", -1);
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("info", "MySQL error!");
				jsonObject.put("data", jsonObject1);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    request.setCharacterEncoding("UTF-8");
				response.getWriter().append(jsonObject.toString());
				e.printStackTrace();
			}
		}else if(role.equals("collector")) {
			try {
				Collector vo = new Collector();
				vo.setEmail(email);
				vo.setPassword(password);
				if(DAOFactory.getICollectorDAOInstance().isInDatabase(vo)) {
					vo = DAOFactory.getICollectorDAOInstance().findByEmail(email);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", 0);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("email", vo.getEmail());
					jsonObject1.put("password", vo.getPassword());
					jsonObject1.put("name", vo.getName());
					jsonObject.put("data", jsonObject1);
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    request.setCharacterEncoding("UTF-8");
					response.getWriter().append(jsonObject.toString());
					request.getSession().setAttribute("userInfo", jsonObject.toString());
				}else {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("code", -1);
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("info", "email or password error!");
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
