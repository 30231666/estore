package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;
import com.briup.estore.service.impl.CustomerServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;

@WebServlet("/ToShopCardServlet")
public class ToShopCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		String nums = request.getParameter("num");
		
		if(ids !=null && nums!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			int num = Integer.parseInt(request.getParameter("num"));
			BookServiceImpl bookServiceImpl = new BookServiceImpl();
			Book book = bookServiceImpl.selectBook(id);
			OrderLine line = new OrderLine();
			line.setBook(book);
			line.setNum(num);
			line.setCost(line.getNum()*book.getPrice());
			HttpSession session = request.getSession();
			ShopCar car = (ShopCar)session.getAttribute("car");
			if(car!=null)
			car.addShopCar(line);
		}
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/shopcard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
