package com.yeahbutstill.catalog.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookCreateRequestDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4168927649902160611L;

    @NotBlank
    private String bookTitle;

    @NotEmpty
    private List<String> authorIdList;

    @NotEmpty
    private List<String> categoryList;

    @NotBlank
    private String publisherId;

    @JsonProperty("synopsis")
    private String description;

}
