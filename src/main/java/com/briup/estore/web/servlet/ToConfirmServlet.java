package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.impl.CustomerServiceImpl;
import com.briup.estore.service.impl.ShopAddresserviceImpl;
@WebServlet("/ToConfirmServlet")
public class ToConfirmServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer);
		ShopAddresserviceImpl shopAddresserviceImpl = new ShopAddresserviceImpl();
		List<ShopAddress> Addresslist = shopAddresserviceImpl.findAddressByCust(customer.getId());
		System.out.println(Addresslist);
		request.setAttribute("addresslist",Addresslist);
		request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
