package com.subrutin.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.subrutin.catalog.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	//method name convention
	//find+keyword
	//sql -> select * from Author a where a.id= :authorId
	public Optional<Author> findById(Long id);
	
	//sql -> select a from Author a where a.author_name = :authorName
	public List<Author> findByNameLike(String authorName);
	
	
}
