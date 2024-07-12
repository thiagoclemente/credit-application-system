package br.com.t2cdigital.credit.application.system.controller

import br.com.t2cdigital.credit.application.system.dto.CustomerRequestCreateDto
import br.com.t2cdigital.credit.application.system.dto.CustomerRequestUpdateDto
import br.com.t2cdigital.credit.application.system.dto.CustomerResponseDto
import br.com.t2cdigital.credit.application.system.entity.Customer
import br.com.t2cdigital.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {
    @PostMapping
    fun saveCustomer(@RequestBody customerRequestCreateDTO: CustomerRequestCreateDto): Customer =
        customerService.save(customerRequestCreateDTO.toEntity())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerResponseDto {
        val customer = customerService.findById(id)
        return CustomerResponseDto(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): Unit = customerService.delete(id)

    @PatchMapping()
    fun updateCustomer(@RequestParam(value = "customerId") id: Long, @RequestBody customerRequestUpdateDto: CustomerRequestUpdateDto): CustomerResponseDto {
        val customer: Customer = customerService.findById(id)
        val customerToUpdate: Customer = customerRequestUpdateDto.toEntity(customer)
        val customerUpdadated: Customer = customerService.save(customerToUpdate)

        return CustomerResponseDto(customerUpdadated)
    }
}