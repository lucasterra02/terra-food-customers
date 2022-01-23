package com.terra.food.customers.exception

import com.terra.food.customers.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            500,
            "Este Recurso não existe",
            "0001",
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
}