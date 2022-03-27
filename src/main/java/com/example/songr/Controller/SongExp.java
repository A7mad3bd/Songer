package com.example.songr.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SongExp {
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class SongNotFoundException extends RuntimeException {

        public SongNotFoundException() {
        }

        public SongNotFoundException(String message) {
            super(message);
        }
    }
}