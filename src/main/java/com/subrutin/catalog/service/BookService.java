package com.subrutin.catalog.service;

import java.util.List;

import com.subrutin.catalog.domain.dto.BookCreateRequestDTO;
import com.subrutin.catalog.domain.dto.BookDetailResponseDTO;
import com.subrutin.catalog.domain.dto.BookListResponseDTO;
import com.subrutin.catalog.domain.dto.BookUpdateRequestDTO;
import com.subrutin.catalog.domain.dto.ResultPageResponseDTO;

public interface BookService {

	public BookDetailResponseDTO findBookDetailById(String bookId);

	public List<BookDetailResponseDTO> findBookListDetail();

	public void createNewBook(BookCreateRequestDTO dto);

	public void updateBook(Long bookId, BookUpdateRequestDTO dto);

	public void deleteBook(Long bookId);

	public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer page, Integer limit, String sortBy,
			String direction, String publisherName, String bookTitle, String authorName);

}
