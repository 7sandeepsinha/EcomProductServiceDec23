package dev.sandeep.EcomProductServiceDec23.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    private String message;
    private int code; // error code, http code etc.

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
