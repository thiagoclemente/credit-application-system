package br.com.t2cdigital.credit.application.system.controller

import br.com.t2cdigital.credit.application.system.dto.CreditRequestCreateDto
import br.com.t2cdigital.credit.application.system.dto.CreditResponseDto
import br.com.t2cdigital.credit.application.system.dto.CreditResponseListDto
import br.com.t2cdigital.credit.application.system.entity.Credit
import br.com.t2cdigital.credit.application.system.service.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditRequestCreateDto: CreditRequestCreateDto): Credit =
        creditService.save(creditRequestCreateDto.toEntity())

    @GetMapping
    fun findAllByCustomerId(@RequestParam(name = "customerId") customerId: Long): List<CreditResponseListDto> {
        return creditService.findAllByCustomerId(customerId).stream()
            .map { credit: Credit -> CreditResponseListDto(credit) }.collect(Collectors.toList())
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(name = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): CreditResponseDto {
        val credit = creditService.findByCreditCode(customerId, creditCode)

        return CreditResponseDto(credit)
    }
}