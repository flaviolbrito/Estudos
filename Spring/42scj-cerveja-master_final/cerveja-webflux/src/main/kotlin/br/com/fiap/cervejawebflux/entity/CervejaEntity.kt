package br.com.fiap.cervejawebflux.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CervejaEntity (

    @Id
    val id: String? = null,

    val nome: String,
    val tipo: String

)

