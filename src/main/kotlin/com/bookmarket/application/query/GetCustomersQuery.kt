package com.bookmarket.application.query

import com.bookmarket.application.ports.`in`.query.GetCustomersQueryPort
import com.bookmarket.domain.entities.Customer
import com.bookmarket.infrastructure.dtos.toDomain
import com.bookmarket.infrastructure.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetCustomersQuery(
    @Autowired private val customerRepository: CustomerRepository
) : GetCustomersQueryPort {
    override fun getAll(): List<Customer> {
        customerRepository.findAll().let {
            if (it.isEmpty())
                throw Exception("Nada")
            return it.map { dto -> dto.toDomain() }
        }
    }

    override fun get(email: String): Customer {
         return customerRepository.findByEmail(email)?.toDomain() ?: throw Exception("H")

    }
}
