package com.bookmarket.adapters.`in`.web.controllers

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.application.ports.`in`.query.GetCustomersQueryPort
import com.bookmarket.application.ports.`in`.useCases.RegisterCustomerUseCasePort
import com.bookmarket.domain.entities.Customer
import com.bookmarket.domain.exceptions.EmailAlreadyRegistered
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    @Autowired private val register: RegisterCustomerUseCasePort,
    @Autowired private val getCustumer: GetCustomersQueryPort
) {

    @ExceptionHandler(EmailAlreadyRegistered::class)
    fun emailAlreadyRegisteredHandler(ex: EmailAlreadyRegistered): ResponseEntity<String> =
        ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    @PostMapping("/register")
    @Tag(name = "Create a customer")
    fun create(
        @RequestBody customer: PostCustomerRequest
    ): ResponseEntity<Customer> =
        ResponseEntity(register.createCustomer(customer), HttpStatus.CREATED)

    @GetMapping("/customers")
    @Tag(name = "Get all customers")
    fun getAllCustomer(): ResponseEntity<List<Customer>> =
        getCustumer.getAll().let { ResponseEntity.ok(it.toList()) }
}
