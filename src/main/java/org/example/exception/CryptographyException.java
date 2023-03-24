package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CryptographyException extends Exception{
    public CryptographyException(String message) {
        super(message);
    }
}
