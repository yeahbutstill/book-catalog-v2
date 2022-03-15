package com.subrutin.catalog.service;

import java.util.List;
import java.util.Map;

import com.subrutin.catalog.domain.dao.Author;
import com.subrutin.catalog.domain.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.domain.dto.AuthorResponseDTO;
import com.subrutin.catalog.domain.dto.AuthorUpdateRequestDTO;

public interface AuthorService {
	
	public AuthorResponseDTO findAuthorById(String id);
	
	public void createNewAuthor(List<AuthorCreateRequestDTO> dto);
	
	public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);
	
	public void deleteAuthor(String authorId);
	
	public List<Author> findAuthors(List<String> authorIdList);
	
	public List<AuthorResponseDTO> constructDTO(List<Author> authors);
	
	public Map<Long, List<String>> findAuthorMaps(List<Long> authorIdList);

}
