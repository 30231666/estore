package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;

public interface OrderLineMapper {
//	public List<Book> selectbook(int id);
	public void insertOrderLine(OrderLine order);
}
