package com.cleanFood.exceptions

import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

@ControllerAdvice
class ExceptionControllerAdvice : ResponseEntityExceptionHandler(){

    @ExceptionHandler(Exception::class)
    public fun handleAllExteptions(ex: Exception, request: WebRequest):ResponseEntity<ExceptionMessage>{
        val errorMessage = ExceptionMessage(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionProductNotFounded::class)
    fun productNotFounded(ex: Exception, request: WebRequest):ResponseEntity<ExceptionMessage>{
        val exceptionMessage = ExceptionMessage(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}