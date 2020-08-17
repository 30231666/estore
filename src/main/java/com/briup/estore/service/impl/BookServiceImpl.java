package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> findBookByClick() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
	    List<Book> selectBookByClick = mapper.selectBookByClick();
		return selectBookByClick;
	}

	@Override
	public List<Book> findAllBook() {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		List<Book> books = mapper.selectBooks();
		return books;
	}

	public Book selectBook(int id) {
		// TODO Auto-generated method stub
		SqlSession Session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = Session.getMapper(BookMapper.class);
		Book book = mapper.selectBook(id);
		//将书籍点击量加1
		book.setClick(book.getClick()+1);
		mapper.updateBook(book);
		Session.commit();
		return book;
	}

	@Override
	public List<Book> findbookByCateId(int cateId) {
		SqlSession Session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = Session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectbookByCateId(cateId);
		return booklist;
	}

	@Override
	public List<Book> findBookByCateIdAndClick(int cateId) {
		SqlSession Session = MyBatisSqlSessionFactory.openSession();
		BookMapper mapper = Session.getMapper(BookMapper.class);
		List<Book> Booklist = mapper.selectBookByCateIdAndClick(cateId);
		return Booklist;
	}





	

	

}
