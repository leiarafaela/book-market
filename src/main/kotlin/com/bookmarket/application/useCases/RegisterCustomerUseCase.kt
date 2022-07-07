package com.bookmarket.application.useCases

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.adapters.`in`.web.controllers.request.toDTO
import com.bookmarket.application.ports.`in`.useCases.RegisterCustomerUseCasePort
import com.bookmarket.infrastructure.dtos.CustomerDTO
import com.bookmarket.infrastructure.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class RegisterCustomerUseCase(
    @Autowired val customerRepository: CustomerRepository
) : RegisterCustomerUseCasePort {

    @Transactional
    override fun createCustomer(request: PostCustomerRequest): CustomerDTO =
        customerRepository.save(request.toDTO())
}
