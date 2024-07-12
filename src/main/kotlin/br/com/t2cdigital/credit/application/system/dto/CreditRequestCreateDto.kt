package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditRequestCreateDto(
    @field:NotNull(message = "creditValue is required")
    val creditValue: BigDecimal,

    @field:Future
    val dayFirstInstallment: LocalDate,

    val numberOfInstallments: Int,

    @field:NotNull(message = "customerId is required")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = creditValue,
        dayFirstInstallment = dayFirstInstallment,
        numberOfInstallments = numberOfInstallments,
        customer = Customer(id = customerId)
    )
}
