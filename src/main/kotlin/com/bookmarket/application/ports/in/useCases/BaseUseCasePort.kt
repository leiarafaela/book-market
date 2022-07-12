package com.bookmarket.application.ports.`in`.useCases

import com.bookmarket.domain.entities.Customer

interface BaseUseCasePort<TRequest, TResponse> {
    fun createCustomer(request: TRequest): Customer?
}
