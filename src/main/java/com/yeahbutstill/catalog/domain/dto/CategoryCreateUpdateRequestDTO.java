package com.yeahbutstill.catalog.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class CategoryCreateUpdateRequestDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7477428048250879182L;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

}
