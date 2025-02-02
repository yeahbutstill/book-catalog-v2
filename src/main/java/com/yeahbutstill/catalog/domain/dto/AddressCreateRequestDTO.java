package com.yeahbutstill.catalog.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressCreateRequestDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5784061789009034284L;

    private String streetName;

    private String cityName;

    private String zipCode;

}
