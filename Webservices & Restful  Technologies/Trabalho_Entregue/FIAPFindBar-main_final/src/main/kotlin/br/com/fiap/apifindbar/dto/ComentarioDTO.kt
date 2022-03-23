package br.com.fiap.apifindbar.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ComentarioDTO(

    var id: String? = null,
    var barId: String? = null,
    val mensagem: String,
    val nota: Int,
    var likes: Int = 0,
    var dislikes: Int = 0,

)
