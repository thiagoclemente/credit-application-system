package br.com.t2cdigital.credit.application.system.service.impl

import br.com.t2cdigital.credit.application.system.entity.Customer
import br.com.t2cdigital.credit.application.system.repository.CustomerRepopsitory
import br.com.t2cdigital.credit.application.system.service.ICustomerService

class CustomerService(
    private val customerRepopsitory: CustomerRepopsitory
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepopsitory.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepopsitory.findById(id).orElseThrow {
            throw RuntimeException(String.format("Customer %s not found", id))
        }

    override fun delete(id: Long) =
        this.customerRepopsitory.deleteById(id)
}