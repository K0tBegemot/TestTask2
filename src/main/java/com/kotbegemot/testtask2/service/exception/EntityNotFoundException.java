package com.kotbegemot.testtask2.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There is no book with such isbn")
public class EntityNotFoundException extends RuntimeException{
}
