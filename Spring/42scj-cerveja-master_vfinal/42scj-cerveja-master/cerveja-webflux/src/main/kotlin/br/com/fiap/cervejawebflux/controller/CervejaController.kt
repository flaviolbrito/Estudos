package br.com.fiap.cervejawebflux.controller

import br.com.fiap.cervejawebflux.dto.CervejaCreateDTO
import br.com.fiap.cervejawebflux.dto.CervejaDTO
import br.com.fiap.cervejawebflux.service.CervejaService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("cervejas")
class CervejaController(
    private val cervejaService: CervejaService
) {

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll(): Flux<CervejaDTO> = cervejaService.findAll()

    @PostMapping
    fun create(@RequestBody cervejaCreateDTO: CervejaCreateDTO): Mono<CervejaDTO> =
        cervejaService.create(cervejaCreateDTO)

}