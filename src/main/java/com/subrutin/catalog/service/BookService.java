package com.subrutin.catalog.service;

import java.util.List;

import com.subrutin.catalog.dto.BookDetailDTO;

public interface BookService {
	
	public BookDetailDTO findBookDetailById(Long bookId);
	
	public List<BookDetailDTO> findBookListDetail();

}
