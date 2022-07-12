package com.bookmarket.application.useCases

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.adapters.`in`.web.controllers.request.toDTO
import com.bookmarket.application.ports.`in`.dataProviders.LoadCustomerPort
import com.bookmarket.application.ports.`in`.useCases.RegisterCustomerUseCasePort
import com.bookmarket.domain.entities.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class RegisterCustomerUseCase(
    @Autowired val loadCustomer: LoadCustomerPort
) : RegisterCustomerUseCasePort {

    @Transactional
    override fun createCustomer(request: PostCustomerRequest): Customer =
        loadCustomer.save(request.toDTO())
}
