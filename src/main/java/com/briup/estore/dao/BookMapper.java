package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;

public interface BookMapper {
	public List<Book> selectBookByClick();
	public List<Book> selectBooks();
	public Book selectBook(int id);
	public void updateBook(Book book);
	public List<Book> selectbookByCateId(int cateId);
	public List<Book> selectBookByCateIdAndClick(int cateId);
}
