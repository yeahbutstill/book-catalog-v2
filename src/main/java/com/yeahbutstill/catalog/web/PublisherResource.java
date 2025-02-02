package com.yeahbutstill.catalog.web;

import com.yeahbutstill.catalog.annotation.LogThisMethod;
import com.yeahbutstill.catalog.domain.dto.PublisherCreateRequestDTO;
import com.yeahbutstill.catalog.domain.dto.PublisherListResponseDTO;
import com.yeahbutstill.catalog.domain.dto.PublisherUpdateRequestDTO;
import com.yeahbutstill.catalog.domain.dto.ResultPageResponseDTO;
import com.yeahbutstill.catalog.exception.BadRequestException;
import com.yeahbutstill.catalog.service.PublisherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.net.URI;

@Validated
@AllArgsConstructor
@RestController
@SecurityRequirement(name = "bearerAuth")
public class PublisherResource {

    private final PublisherService publisherService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/publisher")
    public ResponseEntity<Void> createNewPublisher(@RequestBody @Valid PublisherCreateRequestDTO dto) {
        publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updatePublisher(@PathVariable
                                                @Size(max = 36, min = 36, message = "publiher.id.not.uuid") String publisherId,
                                                @RequestBody @Valid PublisherUpdateRequestDTO dto) {
        publisherService.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @LogThisMethod
    @GetMapping("/v1/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> findPublisherList(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "publisherName", required = false) String publisherName) {
        if (pages < 0) throw new BadRequestException("invalid pages");
        return ResponseEntity.ok().body(publisherService.findPublisherList(pages, limit, sortBy, direction, publisherName));
    }

}
