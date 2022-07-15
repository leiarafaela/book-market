package com.bookmarket.application.ports.`in`.query

interface BaseQueryPort <TResponse> {
    fun getAll(): List<TResponse>

    fun get(email: String): TResponse
}
