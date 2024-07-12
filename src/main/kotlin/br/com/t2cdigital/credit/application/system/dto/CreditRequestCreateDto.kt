package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditRequestCreateDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = creditValue,
        dayFirstInstallment = dayFirstInstallment,
        numberOfInstallments = numberOfInstallments,
        customer = Customer(id = customerId)
    )
}
