package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerResponseDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val cpf: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        email = customer.email,
        cpf = customer.cpf,
        income = customer.income,
        street = customer.address.street,
        zipCode = customer.address.zipCode
    )
}