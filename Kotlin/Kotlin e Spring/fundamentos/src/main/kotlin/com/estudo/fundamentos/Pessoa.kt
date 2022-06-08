package com.estudo.fundamentos

class Pessoa (var nome: String, var idade: Int) {
    override fun toString(): String {
        return "Classe: Pessoa Nome:  ${nome}, idade: ${idade}"
        }

}

fun main(){
    var gustavo = Pessoa("Gustavo",24)
    println(gustavo)
}

