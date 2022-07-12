package com.bookmarket.infrastructure.repository

import com.bookmarket.infrastructure.dtos.CustomerDTO
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CustomerRepository : CrudRepository<CustomerDTO, UUID> {
    fun findByEmail(email: String): CustomerDTO
}
