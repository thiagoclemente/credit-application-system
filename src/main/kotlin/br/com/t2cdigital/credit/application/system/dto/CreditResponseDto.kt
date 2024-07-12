package br.com.t2cdigital.credit.application.system.dto

import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.enumeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditResponseDto(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomerCustomer: BigDecimal?
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomerCustomer = credit.customer?.income
    )
}
