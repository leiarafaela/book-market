package com.bookmarket.adapters.`in`.dataProviders

import com.bookmarket.common.annotation.LoadAdapter
import com.bookmarket.domain.entities.Customer
import com.bookmarket.domain.exceptions.EmailAlreadyRegistered
import com.bookmarket.infrastructure.dtos.CustomerDTO
import com.bookmarket.infrastructure.dtos.toDomain
import com.bookmarket.infrastructure.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import com.bookmarket.application.ports.`in`.dataProviders.LoadCustomerPort as LoadCustomerPort

@LoadAdapter
class LoadCustomerAdapter(
    @Autowired val customerRepository: CustomerRepository
) : LoadCustomerPort {
    private fun validateEmail(customer: CustomerDTO) {
        if (customerRepository.findByEmail(customer.email) != null) {
            throw EmailAlreadyRegistered("This email ${customer.email} is already registered")
        }
    }
    override fun save(customer: CustomerDTO): Customer {
        validateEmail(customer)
        return customerRepository.save(customer).toDomain()
    }
}
