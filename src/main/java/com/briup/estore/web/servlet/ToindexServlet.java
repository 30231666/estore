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

//@WebServlet("/toindexServlet")
public class ToindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		List<Category> Categorylist = categoryService.findFirstWithSecondCategory();
		//System.out.println("-------"+Categorylist);
		request.setAttribute("categorylist", Categorylist);
		
		
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> findBookByClick = bookServiceImpl.findBookByClick();
		List<Book> findAllBook = bookServiceImpl.findAllBook();
		request.setAttribute("findbooklist", findBookByClick);
		request.setAttribute("findalllist", findAllBook);
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
