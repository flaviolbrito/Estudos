package br.com.fiap.cervejawebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CervejaWebfluxApplication

fun main(args: Array<String>) {
	runApplication<CervejaWebfluxApplication>(*args)
}
