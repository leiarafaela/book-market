package com.bookmarket.application.ports.`in`.query

interface BaseQueryPort <TResponse> {
    fun getAll(): TResponse
}
