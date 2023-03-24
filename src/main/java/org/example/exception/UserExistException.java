package org.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserExistException extends Exception{
    public UserExistException(String message) {
        super(message);
    }
}
