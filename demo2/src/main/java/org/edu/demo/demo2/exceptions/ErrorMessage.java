package org.edu.demo.demo2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ErrorMessage {
    private String message;
    private String statues;

}
