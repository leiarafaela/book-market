package com.bookmarket.adapters.`in`.web.controllers.request

import com.bookmarket.domain.enums.CustomerStatus
import com.bookmarket.infrastructure.dtos.CustomerDTO

data class PostCustomerRequest(
    val name: String,
    val email: String
)

fun PostCustomerRequest.toDTO(): CustomerDTO =
    CustomerDTO(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
