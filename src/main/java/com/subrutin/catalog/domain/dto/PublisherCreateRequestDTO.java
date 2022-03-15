package com.subrutin.catalog.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//@LogThisArg
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateRequestDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6264675048939616940L;

    @NotBlank(message = "publisher.must.not.blank")
    private String publisherName;

    @NotBlank(message = "company_name.must.not.blank")
    private String companyName;

    private String address;

}
