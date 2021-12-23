package ex07.main;

import ex07.model.ContaBancaria;

// Exercicio de Separar Classes em Pacotes

/**
 * @author dnvtrn
 *
 */
public class TesteContas {

	/**
	 * @param args
	 */


	public static void main(String[] args) {

		ContaBancaria c1 = new ContaBancaria();
		c1.setTitular("Dan");
		c1.deposita(100);
		System.out.println("Saldo: "  + c1.getSaldo());
		c1.saque(10);
		System.out.println("Saldo 1: " + c1.getSaldo());
		System.out.println("Nome: " + c1.getTitular());
	}
}