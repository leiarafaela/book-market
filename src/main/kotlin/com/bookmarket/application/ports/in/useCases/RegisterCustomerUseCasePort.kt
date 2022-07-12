package com.bookmarket.application.ports.`in`.useCases

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.domain.entities.Customer

interface RegisterCustomerUseCasePort : BaseUseCasePort<PostCustomerRequest, Customer>
