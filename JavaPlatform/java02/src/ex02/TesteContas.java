package ex02;

public class TesteContas {

	public static void main(String[] args) {
		
		ContaBancaria conta = new ContaBancaria();

		//exemplo de sobrecarga de método
		System.out.println(conta.getTaxaBancaria());
		System.out.println(conta.getTaxaBancaria(10));
		System.out.println(conta.getTaxaBancaria(1,1));

	}

}
