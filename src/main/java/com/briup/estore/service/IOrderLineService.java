package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;

public interface IOrderLineService {
//	public List<Book> findBook(int id);
	public void insertOrderline(OrderLine order);
} 
