package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerRequestUpdateDto(
    @field:NotEmpty(message = "firstname is required")
    val firstName: String,

    @field:NotEmpty(message = "lastName is required")
    val lastName: String,

    @field:NotEmpty(message = "firstname is required")
    @field:Email(message = "email is invalid")
    val email: String,

    @field:NotNull(message = "income is required")
    val income: BigDecimal,

    @field:NotEmpty(message = "street is required")
    val street: String,

    @field:NotEmpty(message = "zipCode is required")
    val zipCode: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = firstName
        customer.lastName = lastName
        customer.email = email
        customer.income = income
        customer.address.street = street
        customer.address.zipCode = zipCode

        return customer
    }
}