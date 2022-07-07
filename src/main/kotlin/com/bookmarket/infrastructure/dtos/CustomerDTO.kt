package com.bookmarket.infrastructure.dtos

import com.bookmarket.domain.entities.Customer
import com.bookmarket.domain.enums.CustomerStatus
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
data class CustomerDTO(

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = null,

    @Column
    val name: String? = null,

    @Column
    val email: String? = null,

    @Column
    val status: CustomerStatus
)

fun Customer.toDTO(
    id: UUID,
    name: String,
    email: String,
    status: CustomerStatus
): CustomerDTO =
    CustomerDTO(
        id = id,
        name = name,
        email = email,
        status = status
    )

fun CustomerDTO.toDomain(
    id: UUID,
    name: String,
    email: String,
    status: CustomerStatus
): Customer =
    Customer(
        id = id,
        name = name,
        email = email,
        status = status
    )
