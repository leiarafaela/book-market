package com.bookmarket.application.ports.`in`.dataProviders

import com.bookmarket.domain.entities.Customer
import com.bookmarket.infrastructure.dtos.CustomerDTO

interface LoadCustomerPort {
    fun save(customer: CustomerDTO): Customer
}
