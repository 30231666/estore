package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookService {
	public List<Book> findBookByClick();
	public List<Book> findAllBook();
	public Book selectBook(int id);
	public List<Book> findbookByCateId(int cateId);
	public List<Book> findBookByCateIdAndClick(int cateId);
} 
