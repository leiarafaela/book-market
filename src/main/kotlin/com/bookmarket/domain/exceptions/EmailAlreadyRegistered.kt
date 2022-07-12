package com.bookmarket.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class EmailAlreadyRegistered(message: String, cause: Throwable = Exception(message)) :
    RuntimeException(message, cause)
