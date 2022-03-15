package com.yeahbutstill.catalog.web;

import com.yeahbutstill.catalog.domain.dto.AuthorCreateRequestDTO;
import com.yeahbutstill.catalog.domain.dto.AuthorResponseDTO;
import com.yeahbutstill.catalog.domain.dto.AuthorUpdateRequestDTO;
import com.yeahbutstill.catalog.service.AuthorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@SecurityRequirement(name = "bearerAuth")
public class AuthorResource {

    private final AuthorService authorService;

    //author detail
    @GetMapping("/v1/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable String id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    @PostMapping("/v1/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto) {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }


    @PutMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String authorId,
                                             @RequestBody AuthorUpdateRequestDTO dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }


}
