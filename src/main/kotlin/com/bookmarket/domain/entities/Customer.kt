package com.bookmarket.domain.entities

import com.bookmarket.domain.enums.CustomerStatus
import java.time.LocalDateTime

class Customer(
    val name: String,
    val email: String,
    val status: CustomerStatus,
    val createdAt: LocalDateTime
)
