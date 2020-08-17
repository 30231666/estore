package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.impl.CustomerServiceImpl;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;
import com.briup.estore.service.impl.ShopAddresserviceImpl;
@WebServlet("/ToOrderListServlet")
public class ToOrderListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar)session.getAttribute("car");
		Customer customer = (Customer)session.getAttribute("customer");
		String addId = request.getParameter("shopAddId");
		ShopAddresserviceImpl shopAddresserviceImpl = new ShopAddresserviceImpl();
		ShopAddress shopAddress = shopAddresserviceImpl.findAddressByid(Integer.parseInt(addId));
		OrderForm order = new OrderForm();
		order.setCost(car.getCost());
		order.setCustomer(customer);
		order.setOrderdate(new Date());
		order.setShopAddress(shopAddress);
//		session.setAttribute("shopAddress", shopAddress);
		OrderFormServiceImpl orderFormServiceImpl = new OrderFormServiceImpl();
		orderFormServiceImpl.insertOrder(order);
		Map<Integer, OrderLine> map = car.getOrderLines();
		Set<Entry<Integer, OrderLine>> entrySet = map.entrySet();
		OrderLineServiceImpl orderLineServiceImpl = new OrderLineServiceImpl();
		for(Entry<Integer, OrderLine> entry:entrySet) {
			OrderLine line = entry.getValue();
			line.setOrder(order);
			orderLineServiceImpl.insertOrderline(line);
		}
		List<OrderForm> orderList = orderFormServiceImpl.findOrderByCustId(customer.getId());
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/WEB-INF/jsp/orderlist.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
