package com.yeahbutstill.catalog.service;

import com.yeahbutstill.catalog.domain.dto.*;

import java.util.List;

public interface BookService {

    BookDetailResponseDTO findBookDetailById(String bookId);

    List<BookDetailResponseDTO> findBookListDetail();

    void createNewBook(BookCreateRequestDTO dto);

    void updateBook(Long bookId, BookUpdateRequestDTO dto);

    void deleteBook(Long bookId);

    ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer page, Integer limit, String sortBy,
                                                            String direction, String publisherName, String bookTitle, String authorName);

}
