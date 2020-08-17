package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.impl.CustomerServiceImpl;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		System.out.println(name+password);
		String url ="";
		try {
			Customer customer = customerServiceImpl.findCustomerByName(name, password);
			HttpSession session = request.getSession();
			ShopCar shopCar = new ShopCar();
			session.setAttribute("customer", customer);
			session.setAttribute("car", shopCar);
			url ="/toindexServlet";
		} catch (Exception e) {
			url = "/toLoginServlet";
		}
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
