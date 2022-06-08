package com.estudo.fundamentos

fun main ()
{
    // print1a10()
    // print1a10B()
    // print10a1()
    // printRange(3,9)
    whileMenorQue10()
    doWhileMenorQue10()

}

fun print1a10() {
    for (numero in 1..10)
        println(numero)
}

fun print1a10B() {
    for (numero in 1..10 step 2)
        println(numero)
}

fun print10a1() {
    for (numero in  10 downTo 1)
        println(numero)
}

fun printRange(inicio: Int, fim: Int)
{
    for (numero in inicio .. fim)
        println(numero)
}

fun whileMenorQue10 (){
    var x = 0
    while (x < 10)
    {
        println(x)
        x++
    }
}

fun doWhileMenorQue10(){
    var x = 0
    do {
        println(x)
        x++
    }while (x <10)
}