package com.subrutin.catalog.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.subrutin.catalog.domain.Book;
import com.subrutin.catalog.repository.BookRepository;

import lombok.Data;

@Data
public class BookRepositoryImpl implements BookRepository{

	private Map<Long, Book> bookMap;

	
	@Override
	public Book findBookById(Long id) {
		Book book = bookMap.get(id);
		return book;
	}


	@Override
	public List<Book> findAll() {
		List<Book> bookList = new ArrayList<Book>(bookMap.values());
		return bookList;
	}

}
