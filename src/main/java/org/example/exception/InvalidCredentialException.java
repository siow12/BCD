package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidCredentialException extends Exception{
    public InvalidCredentialException(String message) {
        super(message);
    }
}
