package br.com.fiap.cervejawebflux.service

import br.com.fiap.cervejawebflux.dto.CervejaCreateDTO
import br.com.fiap.cervejawebflux.dto.CervejaDTO
import br.com.fiap.cervejawebflux.entity.CervejaEntity
import br.com.fiap.cervejawebflux.repository.CervejaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class CervejaServiceImpl(
    val cervejaRepository: CervejaRepository
) : CervejaService {

    override fun findAll() = cervejaRepository.findAll()
        .map {
            CervejaDTO(
                id = it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST),
                nome = it.nome,
                tipo = it.tipo
            )
        }.delayElements(Duration.ofSeconds(2))

    override fun create(cervejaCreateDTO: CervejaCreateDTO) = Mono.just(cervejaCreateDTO)
        .map { CervejaEntity(nome = it.nome, tipo = it.tipo) }
        .flatMap { cervejaRepository.save(it) }
        .map {
            CervejaDTO(
                id = it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST),
                nome = it.nome,
                tipo = it.tipo
            )
        }
}