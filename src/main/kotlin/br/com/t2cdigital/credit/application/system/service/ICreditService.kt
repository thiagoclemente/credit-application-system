package br.com.t2cdigital.credit.application.system.service

import br.com.t2cdigital.credit.application.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomerId(customerId: String): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}