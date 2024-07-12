package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerRequestUpdateDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val income: BigDecimal,
    val street: String,
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