package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class ShopAddresserviceImpl implements IShopAddressService {

	@Override
	public List<ShopAddress> findAddressByCust(int custid) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		List<ShopAddress> AddressList = mapper.selectAddressByCustId(custid);
		return AddressList;
	}

	@Override
	public ShopAddress findAddressByid(int id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		ShopAddress Address = mapper.selectAddressById(id);
		return Address;
	}

	
	


	

	

}
