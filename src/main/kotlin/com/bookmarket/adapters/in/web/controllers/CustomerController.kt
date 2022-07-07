package com.bookmarket.adapters.`in`.web.controllers

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.application.ports.`in`.useCases.RegisterCustomerUseCasePort
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class CustomerController(
    @Autowired private val register: RegisterCustomerUseCasePort
) {
    @PostMapping("api/register")
    @Tag(name = "Create a customer")
    fun create(
        @RequestBody customer: PostCustomerRequest
    ): ResponseEntity<Nothing> =
        register.createCustomer(customer)
            .let { ResponseEntity.created(URI.create("api/register/${it.id}")).build() }
}
