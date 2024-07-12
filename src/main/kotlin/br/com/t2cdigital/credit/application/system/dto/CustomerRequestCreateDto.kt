package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Address
import br.com.t2cdigital.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerRequestCreateDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
) {
    fun toEntity(): Customer = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        income = income,
        email = email,
        password = password,
        address = Address(
            street = street,
            zipCode = zipCode
        )
    )
}
