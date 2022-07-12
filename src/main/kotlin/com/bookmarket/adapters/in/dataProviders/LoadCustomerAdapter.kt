package com.bookmarket.adapters.`in`.dataProviders

import com.bookmarket.common.annotation.LoadAdapter
import com.bookmarket.domain.entities.Customer
import com.bookmarket.infrastructure.dtos.CustomerDTO
import com.bookmarket.infrastructure.dtos.toDomain
import com.bookmarket.infrastructure.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import com.bookmarket.application.ports.`in`.dataProviders.LoadCustomerPort as LoadCustomerPort

@LoadAdapter
class LoadCustomerAdapter(
    @Autowired val customerRepository: CustomerRepository
) : LoadCustomerPort {
    override fun save(customer: CustomerDTO): Customer =
        customerRepository.save(customer).toDomain()
}
