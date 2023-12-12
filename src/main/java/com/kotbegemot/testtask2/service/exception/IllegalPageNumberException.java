package com.kotbegemot.testtask2.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There is no page with such number")
public class IllegalPageNumberException extends RuntimeException
{
}