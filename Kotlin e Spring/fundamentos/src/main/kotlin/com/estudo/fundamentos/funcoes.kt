package com.estudo.fundamentos

fun main(): Unit {
    println("Hello word")
    println(retornaNome())
    dizOI(retornaNome(),24, false)

}

fun retornaNome(): String {
   return "Gustavo"
}

fun dizOI(nome: String, idade: Int, myTest : Boolean)
{
    println("01 ${nome}, parabens pelo seus ${idade}  anos ${myTest}" )
}