package br.com.t2cdigital.credit.application.system.controller

import br.com.t2cdigital.credit.application.system.dto.CustomerRequestCreateDto
import br.com.t2cdigital.credit.application.system.dto.CustomerRequestUpdateDto
import br.com.t2cdigital.credit.application.system.dto.CustomerResponseDto
import br.com.t2cdigital.credit.application.system.entity.Customer
import br.com.t2cdigital.credit.application.system.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerRequestCreateDTO: CustomerRequestCreateDto): ResponseEntity<Customer> {
        val customer = customerService.save(customerRequestCreateDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(customer)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerResponseDto> {
        val customer = customerService.findById(id)
        return ResponseEntity.ok().body(CustomerResponseDto(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): Unit = customerService.delete(id)

    @PatchMapping()
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody @Valid customerRequestUpdateDto: CustomerRequestUpdateDto
    ): ResponseEntity<CustomerResponseDto> {
        val customer: Customer = customerService.findById(id)
        val customerToUpdate: Customer = customerRequestUpdateDto.toEntity(customer)
        val customerUpdated: Customer = customerService.save(customerToUpdate)

        return ResponseEntity.ok(CustomerResponseDto(customerUpdated))
    }
}