package com.cleanFood.exceptions

import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    public fun handleIlegalStateExcetion(ex: IllegalStateException):ResponseEntity<ExceptionMessage>{
        val errorMessage = ExceptionMessage(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }
}