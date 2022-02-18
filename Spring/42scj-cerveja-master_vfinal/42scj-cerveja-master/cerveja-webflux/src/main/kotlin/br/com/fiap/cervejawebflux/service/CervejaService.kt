package br.com.fiap.cervejawebflux.service

import br.com.fiap.cervejawebflux.dto.CervejaCreateDTO
import br.com.fiap.cervejawebflux.dto.CervejaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CervejaService {

    fun findAll(): Flux<CervejaDTO>

    fun create(cervejaCreateDTO: CervejaCreateDTO): Mono<CervejaDTO>

}