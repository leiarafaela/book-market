package com.bookmarket.application.ports.`in`.useCases

import com.bookmarket.adapters.`in`.web.controllers.request.PostCustomerRequest
import com.bookmarket.infrastructure.dtos.CustomerDTO

interface RegisterCustomerUseCasePort : BaseUseCasePort<PostCustomerRequest, CustomerDTO>
