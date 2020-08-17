package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

@WebServlet("/TolistServlet")
public class TolistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int j = Integer.parseInt(request.getParameter("id"));
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> booklist = bookServiceImpl.findbookByCateId(j);
		List<Book> topBooklist = bookServiceImpl.findBookByCateIdAndClick(j);
		request.setAttribute("booklist", booklist);
		request.setAttribute("topBooklist", topBooklist);
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
