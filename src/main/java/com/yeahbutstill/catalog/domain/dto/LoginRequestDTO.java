package com.yeahbutstill.catalog.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequestDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4553862933056697530L;

    private String username;

    private String password;
}
