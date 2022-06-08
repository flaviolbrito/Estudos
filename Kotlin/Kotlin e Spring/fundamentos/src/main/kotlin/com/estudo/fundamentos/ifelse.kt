package com.estudo.fundamentos

fun main(){
    println( parOuImpar(2))
    println( parOuImpar(3))

    resultadoDaNota(3)
    resultadoDaNota(5)
    resultadoDaNota(8)
}

fun parOuImpar(numero: Int): String  {
  return if (numero % 2 == 0) { "par"} else { "impar"}
}

//fun parOuImpar(numero: Int)  {
//    if (numero % 2 == 0) {
//        println("par")
//    }
//    else
//    {
//        println("impar")
//    }
//}

// se a nota > 6
// se a nota > 4 recuperacao
// se a nota < 4 reprovou

fun resultadoDaNota (nota: Int) {
    if (nota >= 6) {
        println("Passou")
    } else if (nota >= 4) {
        println("recuperacao")
    } else  {
        println("reprovou")
    }
}





