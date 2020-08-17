package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Customer;

public interface ICustomerService {
	public void register(Customer customer) throws Exception;
	public Customer findCustomerByName(String name ,String password) throws Exception;
}
