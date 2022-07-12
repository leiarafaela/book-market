package com.bookmarket.infrastructure.dtos

import com.bookmarket.domain.entities.Customer
import com.bookmarket.domain.enums.CustomerStatus
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
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
    val name: String,

    @Column
    val email: String,

    @Column
    val status: CustomerStatus,

    @CreatedDate
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),
)

fun CustomerDTO.toDomain(): Customer =
    Customer(
        name = this.name,
        email = this.email,
        status = this.status,
        createdAt = this.createdAt
    )
