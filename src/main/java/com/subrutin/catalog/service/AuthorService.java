package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.dao.Author;
import com.subrutin.catalog.domain.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.domain.dto.AuthorResponseDTO;
import com.subrutin.catalog.domain.dto.AuthorUpdateRequestDTO;

import java.util.List;
import java.util.Map;

public interface AuthorService {

    AuthorResponseDTO findAuthorById(String id);

    void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);

    void deleteAuthor(String authorId);

    List<Author> findAuthors(List<String> authorIdList);

    List<AuthorResponseDTO> constructDTO(List<Author> authors);

    Map<Long, List<String>> findAuthorMaps(List<Long> authorIdList);

}
