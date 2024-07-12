package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Address
import br.com.t2cdigital.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerRequestCreateDto(
    @field:NotEmpty(message = "firstname is required")
    val firstName: String,

    @field:NotEmpty(message = "lastname is required")
    val lastName: String,

    @field:NotEmpty(message = "cpf is required")
    @field:CPF(message = "cpf is invalid")
    val cpf: String,

    @field:NotNull(message = "income is required")
    val income: BigDecimal,

    @field:NotEmpty(message = "email is required")
    @field:Email(message = "email is invalid")
    val email: String,

    @field:NotEmpty(message = "password is required")
    val password: String,

    @field:NotEmpty(message = "zipCode is required")
    val zipCode: String,

    @field:NotEmpty(message = "street is required")
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
