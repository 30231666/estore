package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderForm;

public interface OrderFormMapper {
	public void insertOrder(OrderForm order);
	public List<OrderForm> selectorderByCustId(int custId);
}
