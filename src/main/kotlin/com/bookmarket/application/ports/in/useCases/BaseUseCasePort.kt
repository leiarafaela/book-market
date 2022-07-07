package com.bookmarket.application.ports.`in`.useCases

interface BaseUseCasePort<TRequest, TResponse> {
    fun createCustomer(request: TRequest): TResponse
}
