package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ShopAddress;

public interface IShopAddressService {
	public List<ShopAddress> findAddressByCust(int custid);
	public ShopAddress findAddressByid(int id);
} 
