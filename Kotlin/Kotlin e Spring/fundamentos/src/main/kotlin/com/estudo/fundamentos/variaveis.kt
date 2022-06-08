package com.estudo.fundamentos

fun main() {
    var nome = "Gustavo"
    val nomeval = "Gustavo"

    nome = "Daniel"
    // nomeval = "Daniel" - nao deixa atribuir
}

class variaveis {
    lateinit var teste: String

    fun iniciaVariaveis() {
        teste = "Teste"
    }
}