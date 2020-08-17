package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;

public interface ShopAddressMapper {
	public List<ShopAddress> selectAddressByCustId(int custid);
	public ShopAddress selectAddressById(int id);
}
