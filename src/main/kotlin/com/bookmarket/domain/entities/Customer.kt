package com.bookmarket.domain.entities

import java.util.UUID

data class Customer(
    val id: UUID,
    val name: String,
    val email: String,
    val status: String
)
