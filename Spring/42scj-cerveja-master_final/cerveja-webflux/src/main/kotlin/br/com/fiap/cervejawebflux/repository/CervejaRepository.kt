package br.com.fiap.cervejawebflux.repository

import br.com.fiap.cervejawebflux.entity.CervejaEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CervejaRepository : ReactiveMongoRepository<CervejaEntity, String>