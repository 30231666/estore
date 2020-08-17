package com.briup.estore.service.impl;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService {

	@Override
	public void insertOrderline(OrderLine order) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.insertOrderLine(order);
		session.commit();
	}

	

//	@Override
//	public List<Book> findBook(int id) {
//		SqlSession session = MyBatisSqlSessionFactory.openSession();
//		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
//		List<Book> booklist = mapper.selectbook(id);
//		return booklist;
//	}
	
	

}
