package com.yeahbutstill.catalog.repository;

import com.yeahbutstill.catalog.domain.dao.Book;
import com.yeahbutstill.catalog.domain.dto.BookQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findById(Long id);

    //SQL : select n from book b WHERE b.secure_id = :id
    //JPQL : select b FROM Book b WHERE b.secureId=:id
    public Optional<Book> findBySecureId(String id);


    //SELECT b FROM book b INNER JOIN publisher p ON p.id = b.publisher_id WHERE p.name = :publisherName AND b.title= :bookTitle
    @Query("SELECT DISTINCT new com.yeahbutstill.catalog.domain.dto.BookQueryDTO(b.id,b.secureId, b.title, p.name, b.description ) "
            + "FROM Book b "
            + "INNER JOIN Publisher p ON p.id = b.publisher.id "
            + "JOIN  b.authors ba "
            + "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',:publisherName,'%'))"
            + " AND LOWER(b.title) LIKE LOWER(CONCAT('%',:bookTitle,'%')) "
            + "AND LOWER(ba.name) LIKE LOWER(CONCAT('%',:authorName,'%'))")
    public Page<BookQueryDTO> findBookList(String bookTitle, String publisherName, String authorName, Pageable pageable);

//	
//	public List<Book> findAll();
//	
//	public void save(Book book);
//	
//	public void update(Book book);
//	
//	public void delete(Long bookId);


}
