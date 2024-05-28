package com.av.prod.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class ErrorDTO {
    private String message;
    private int errorCode;
}
