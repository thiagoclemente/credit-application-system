package br.com.t2cdigital.credit.application.system.service.impl

import br.com.t2cdigital.credit.application.system.entity.Customer
import br.com.t2cdigital.credit.application.system.repository.CustomerRepository
import br.com.t2cdigital.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException(String.format("Customer %s not found", id))
        }

    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)
}