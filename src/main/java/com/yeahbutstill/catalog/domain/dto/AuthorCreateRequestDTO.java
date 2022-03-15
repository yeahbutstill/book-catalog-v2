package com.yeahbutstill.catalog.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class AuthorCreateRequestDTO {

    @NotBlank
    private String authorName;

    @NotNull
    private Long birthDate;

    private List<AddressCreateRequestDTO> addresses;
}
