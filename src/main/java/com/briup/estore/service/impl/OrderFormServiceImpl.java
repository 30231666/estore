package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements  IOrderFormService{

	@Override
	public void insertOrder(OrderForm order) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.insertOrder(order);
		session.commit();
	}

	@Override
	public List<OrderForm> findOrderByCustId(int custId) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		List<OrderForm> selectorderByCustId = mapper.selectorderByCustId(custId);
		return selectorderByCustId;
	}

	



	

	

}
