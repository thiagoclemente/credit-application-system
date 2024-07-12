package br.com.t2cdigital.credit.application.system.controller

import br.com.t2cdigital.credit.application.system.dto.CreditRequestCreateDto
import br.com.t2cdigital.credit.application.system.dto.CreditResponseDto
import br.com.t2cdigital.credit.application.system.dto.CreditResponseListDto
import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.service.impl.CreditService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditRequestCreateDto: CreditRequestCreateDto): ResponseEntity<Credit> {
        val credit = creditService.save(creditRequestCreateDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(credit)
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(name = "customerId") customerId: Long): ResponseEntity<List<CreditResponseListDto>> {
        val creditList = creditService.findAllByCustomerId(customerId).stream()
            .map { credit: Credit -> CreditResponseListDto(credit) }.collect(Collectors.toList())

        return ResponseEntity.ok(creditList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(name = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditResponseDto> {
        val credit = creditService.findByCreditCode(customerId, creditCode)

        return ResponseEntity.status(HttpStatus.OK).body(CreditResponseDto(credit))
    }
}