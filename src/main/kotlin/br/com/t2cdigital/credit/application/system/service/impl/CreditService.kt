package br.com.t2cdigital.credit.application.system.service.impl

import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.repository.CreditRepository
import br.com.t2cdigital.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return creditRepository.save(credit)
    }

    override fun findAllByCustomerId(customerId: Long): List<Credit> = creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit =
            creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit code $creditCode not found")

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Customer ID $customerId not found")
    }
}