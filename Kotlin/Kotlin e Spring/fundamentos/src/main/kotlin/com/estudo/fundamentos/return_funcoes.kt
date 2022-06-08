package com.estudo.fundamentos

// multiplos returns

fun retornaNumeroPorExtenso(numero: Int): String {
        if (numero == 5) { return "cinco"} else { return "nao encontrado"}
}

fun  main(){
    print(retornaNumeroPorExtenso(5))
}
