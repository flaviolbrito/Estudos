package ex05;

public class TesteContas {
//Exemplo de  Encapsulamento
	public static void main(String[] args) {

		ContaBancaria c1 = new ContaBancaria();
		ContaBancaria c2 = new ContaBancaria();
		c1.deposita(100);
		c2.deposita(100);
		System.out.println(c1.getSaldo());
		c1.saque(10);
		System.out.println(c1.getSaldo());
		System.out.println(ContaBancaria.getIdentificador());

		ContaBancaria c3 = new ContaBancaria("Flavio Teste");
		c3.deposita(200);
		c3.saque(100);
		System.out.println("nome titular: " + c3.getTitular() + "saldo: " + c3.getSaldo());


	}
}