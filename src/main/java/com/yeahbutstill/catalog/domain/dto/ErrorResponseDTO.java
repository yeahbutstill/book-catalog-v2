package com.yeahbutstill.catalog.domain.dto;

import com.yeahbutstill.catalog.enums.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -232016847842798660L;

    private Date timestamp;

    private String message;

    private ErrorCode errorCode;

    private List<String> details;

    private HttpStatus status;


    public ErrorResponseDTO(String message, ErrorCode errorCode, List<String> details, HttpStatus status) {
        super();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.status = status;
        this.timestamp = new Date();
    }

    public static ErrorResponseDTO of(final String message, List<String> details, final ErrorCode errorCode, HttpStatus status) {
        return new ErrorResponseDTO(message, errorCode, details, status);
    }

}
