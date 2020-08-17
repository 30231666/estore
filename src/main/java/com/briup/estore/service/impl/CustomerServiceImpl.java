package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void register(Customer customer) throws Exception {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		//根据用户名查询es_customer，如果查询到一个用户说明该用户名被占用
		List<Customer> Custlist = mapper.selectCustomerByName(customer.getName());
		if(Custlist.size()>0) {
			throw new Exception("该用户名已经被占用，请重新输入");
		}else {
			mapper.insertCustomer(customer);
			session.commit();
		}
		
	}

	@Override
	public Customer findCustomerByName(String name, String password) throws Exception {
		if(name==null ||name.equals("")|| password==null) {
			throw new Exception("name 密码为空");
		}
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> Customerlist = mapper.selectCustomerByName(name);
		
		for(Customer c:Customerlist) {
			System.out.println(c);
			if(c.getPassword().equals(password)){
				return c;
			}
		}			
		throw new Exception("该用户名密码错误，请重新输入");

		
	}

	

}
